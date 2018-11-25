package com.sheygam.java_221_21_11_18_hw;

import android.app.Application;

import com.sheygam.java_221_21_11_18_hw.di.application.AppComponent;
import com.sheygam.java_221_21_11_18_hw.di.application.AppModule;
import com.sheygam.java_221_21_11_18_hw.di.application.DaggerAppComponent;
import com.sheygam.java_221_21_11_18_hw.di.login.LoginComponent;
import com.sheygam.java_221_21_11_18_hw.di.login.LoginModule;

public class App extends Application {
    private static App app;
    private AppComponent component;
    private LoginComponent loginComponent;

    public App() {
        app = this;
    }

    public static App get(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public LoginComponent plus(LoginModule module){
        if (loginComponent == null){
            loginComponent = component.plus(module);
        }
        return loginComponent;
    }

    public void clearLoginComponent(){
        loginComponent = null;
    }
}
