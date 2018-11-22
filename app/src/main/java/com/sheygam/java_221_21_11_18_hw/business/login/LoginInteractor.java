package com.sheygam.java_221_21_11_18_hw.business.login;

import com.sheygam.java_221_21_11_18_hw.data.login.ILoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.login.LoginRepositoryCallback;

public class LoginInteractor implements ILoginInteractor, LoginRepositoryCallback {
    private ILoginRepository repository;
    private LoginInteractorCallback callback;

    public LoginInteractor(ILoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void login(String email, String password, LoginInteractorCallback callback) throws EmailValidException, PasswordValidException {
        this.callback = callback;
        validEmail(email);
        validPassword(password);
        repository.login(email,password,this);
    }




    @Override
    public void registration(String email, String password, LoginInteractorCallback callback) throws EmailValidException, PasswordValidException {
        this.callback = callback;
        validEmail(email);
        validPassword(password);
        repository.registration(email,password,this);
    }

    private void validEmail(String email) throws EmailValidException {
        if(!email.contains("@")){
            throw new EmailValidException("Email must have @!");
        }
    }

    private void validPassword(String password) throws PasswordValidException {
        if(password.length() < 8){
            throw new PasswordValidException("Password minimum 8 symbols!");
        }
    }

    @Override
    public void loginSuccess() {
        callback.loginSuccess();
    }

    @Override
    public void loginFailure(String error) {
        callback.loginFailure(error);
    }

    @Override
    public void registrationSuccess() {
        callback.registrationSuccess();
    }

    @Override
    public void registrationFailure(String error) {
        callback.registrationFailure(error);
    }
}
