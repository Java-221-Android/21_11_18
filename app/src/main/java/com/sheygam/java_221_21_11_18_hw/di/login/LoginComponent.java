package com.sheygam.java_221_21_11_18_hw.di.login;

import com.sheygam.java_221_21_11_18_hw.presentation.login.presenter.LoginPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {RxLoginModule.class})
@LoginScope
public interface LoginComponent {
    void inject(LoginPresenter presenter);
}
