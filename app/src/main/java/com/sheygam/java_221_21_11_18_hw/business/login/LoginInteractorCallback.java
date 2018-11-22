package com.sheygam.java_221_21_11_18_hw.business.login;

public interface LoginInteractorCallback {
    void loginSuccess();
    void loginFailure(String error);
    void registrationSuccess();
    void registrationFailure(String error);
}
