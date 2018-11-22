package com.sheygam.java_221_21_11_18_hw.data.login;

public interface LoginRepositoryCallback {
    void loginSuccess();
    void loginFailure(String error);
    void registrationSuccess();
    void registrationFailure(String error);
}
