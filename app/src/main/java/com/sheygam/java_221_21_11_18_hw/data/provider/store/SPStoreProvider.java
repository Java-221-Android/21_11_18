package com.sheygam.java_221_21_11_18_hw.data.provider.store;

import android.content.Context;

public class SPStoreProvider implements IStoreProvider {
    private static final String SP_AUTH = "auth";
    private static final String TOKEN = "token";
    private Context context;

    public SPStoreProvider(Context context) {
        this.context = context;
    }

    @Override
    public void saveToken(String token) {
        context.getSharedPreferences(SP_AUTH,Context.MODE_PRIVATE)
                .edit()
                .putString(TOKEN,token)
                .commit();
    }

    @Override
    public String getToken() {
        return context.getSharedPreferences(SP_AUTH,Context.MODE_PRIVATE)
                .getString(TOKEN,null);
    }
}
