package com.sheygam.java_221_21_11_18_hw.business.login;

public interface ILoginInteractor {

    void login(String email, String password, LoginInteractorCallback callback) throws EmailValidException,PasswordValidException;
    void registration(String email,String password, LoginInteractorCallback callback) throws EmailValidException,PasswordValidException;
}
