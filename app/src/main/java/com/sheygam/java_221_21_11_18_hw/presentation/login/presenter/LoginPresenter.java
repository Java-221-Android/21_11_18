package com.sheygam.java_221_21_11_18_hw.presentation.login.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.sheygam.java_221_21_11_18_hw.business.login.EmailValidException;
import com.sheygam.java_221_21_11_18_hw.business.login.ILoginInteractor;
import com.sheygam.java_221_21_11_18_hw.business.login.LoginInteractorCallback;
import com.sheygam.java_221_21_11_18_hw.business.login.PasswordValidException;
import com.sheygam.java_221_21_11_18_hw.presentation.login.view.ILoginView;

@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> implements LoginInteractorCallback {

    ILoginInteractor interactor;

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
}
