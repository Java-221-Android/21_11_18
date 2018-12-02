package com.sheygam.java_221_21_11_18_hw.presentation.login.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.sheygam.java_221_21_11_18_hw.App;
import com.sheygam.java_221_21_11_18_hw.business.login.EmailValidException;
import com.sheygam.java_221_21_11_18_hw.business.login.ILoginInteractor;
import com.sheygam.java_221_21_11_18_hw.business.login.LoginInteractor;
import com.sheygam.java_221_21_11_18_hw.business.login.LoginInteractorCallback;
import com.sheygam.java_221_21_11_18_hw.business.login.PasswordValidException;
import com.sheygam.java_221_21_11_18_hw.business.login.RxILoginInteractor;
import com.sheygam.java_221_21_11_18_hw.data.login.ILoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.login.LoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.provider.Api;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.IStoreProvider;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.SPStoreProvider;
import com.sheygam.java_221_21_11_18_hw.di.login.LoginModule;
import com.sheygam.java_221_21_11_18_hw.di.login.RxLoginModule;
import com.sheygam.java_221_21_11_18_hw.presentation.login.view.ILoginView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> implements LoginInteractorCallback {


    @Inject
    RxILoginInteractor rxInteractor;

    private Disposable disposable;

    public LoginPresenter() {
        App.get().plus(new RxLoginModule()).inject(this);
    }

    public void onLogin(String email, String password){
        getViewState().showProgress();
        disposable = rxInteractor.login(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loginSuccess,throwable -> {
                    if(throwable instanceof EmailValidException){
                        getViewState().hideProgress();
                        getViewState().showEmailValidError(throwable.getMessage());
                    }else if(throwable instanceof PasswordValidException){
                        getViewState().hideProgress();
                        getViewState().showPassValidError(throwable.getMessage());
                    }else {
                        loginFailure(throwable.getMessage());
                    }
                });
    }

    public void onRegistration(String email, String password){
        getViewState().showProgress();
        disposable = rxInteractor.registration(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::registrationSuccess,throwable -> {
                    if(throwable instanceof EmailValidException){
                        getViewState().hideProgress();
                        getViewState().showEmailValidError(throwable.getMessage());
                    }else if(throwable instanceof PasswordValidException){
                        getViewState().hideProgress();
                        getViewState().showPassValidError(throwable.getMessage());
                    }else {
                        registrationFailure(throwable.getMessage());
                    }
                });
    }

    @Override
    public void loginSuccess() {
        getViewState().hideProgress();
        getViewState().showNextView();
    }

    @Override
    public void loginFailure(String error) {
        getViewState().hideProgress();
        getViewState().showAuthError(error);
    }

    @Override
    public void registrationSuccess() {
        getViewState().hideProgress();
        getViewState().showNextView();
    }

    @Override
    public void registrationFailure(String error) {
        getViewState().hideProgress();
        getViewState().showAuthError(error);
    }

    @Override
    public void onDestroy() {
        App.get().clearLoginComponent();
        disposable.dispose();
        super.onDestroy();
    }
}
