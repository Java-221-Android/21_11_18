package com.sheygam.java_221_21_11_18_hw.presentation.login.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.sheygam.java_221_21_11_18_hw.App;
import com.sheygam.java_221_21_11_18_hw.business.login.EmailValidException;
import com.sheygam.java_221_21_11_18_hw.business.login.ILoginInteractor;
import com.sheygam.java_221_21_11_18_hw.business.login.LoginInteractor;
import com.sheygam.java_221_21_11_18_hw.business.login.LoginInteractorCallback;
import com.sheygam.java_221_21_11_18_hw.business.login.PasswordValidException;
import com.sheygam.java_221_21_11_18_hw.data.login.ILoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.login.LoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.provider.Api;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.IStoreProvider;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.SPStoreProvider;
import com.sheygam.java_221_21_11_18_hw.di.login.LoginModule;
import com.sheygam.java_221_21_11_18_hw.presentation.login.view.ILoginView;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> implements LoginInteractorCallback {

    @Inject
    ILoginInteractor interactor;

    public LoginPresenter() {
        App.get().plus(new LoginModule()).inject(this);
//        OkHttpClient client = new OkHttpClient();
//        Api api = new Retrofit.Builder()
//                .baseUrl("https://contacts-telran.herokuapp.com/")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(Api.class);
//        IStoreProvider storeProvider = new SPStoreProvider(App.get());
//        ILoginRepository repository = new LoginRepository(api,storeProvider);
//        interactor = new LoginInteractor(repository);

    }

    public void onLogin(String email, String password){
        getViewState().showProgress();
        try {
            interactor.login(email,password,this);
        } catch (EmailValidException e) {
            e.printStackTrace();
            getViewState().hideProgress();
            getViewState().showEmailValidError(e.getMessage());
        } catch (PasswordValidException e) {
            e.printStackTrace();
            getViewState().hideProgress();
            getViewState().showPassValidError(e.getMessage());
        }
    }

    public void onRegistration(String email, String password){
        getViewState().showProgress();
        try {
            interactor.registration(email,password,this);
        } catch (EmailValidException e) {
            e.printStackTrace();
            getViewState().hideProgress();
            getViewState().showEmailValidError(e.getMessage());
        } catch (PasswordValidException e) {
            e.printStackTrace();
            getViewState().hideProgress();
            getViewState().showPassValidError(e.getMessage());
        }
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
        super.onDestroy();
    }
}
