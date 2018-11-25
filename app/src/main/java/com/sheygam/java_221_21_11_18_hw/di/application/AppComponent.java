package com.sheygam.java_221_21_11_18_hw.di.application;

import com.sheygam.java_221_21_11_18_hw.di.login.LoginComponent;
import com.sheygam.java_221_21_11_18_hw.di.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    LoginComponent plus(LoginModule module);
}
