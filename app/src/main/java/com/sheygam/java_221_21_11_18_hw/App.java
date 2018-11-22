package com.sheygam.java_221_21_11_18_hw;

import android.app.Application;

public class App extends Application {
    private static App app;

    public App() {
        app = this;
    }

    public static App get(){
        return app;
    }
}
