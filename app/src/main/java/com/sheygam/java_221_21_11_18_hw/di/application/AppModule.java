package com.sheygam.java_221_21_11_18_hw.di.application;

import android.content.Context;

import com.sheygam.java_221_21_11_18_hw.data.provider.Api;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.IStoreProvider;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.SPStoreProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    OkHttpClient provideClient(){
        return  new OkHttpClient();
    }

    @Provides
    @Singleton
    Api provideApi(OkHttpClient client){
        return new Retrofit.Builder()
                .client(client)
                .baseUrl("https://contacts-telran.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
    }

    @Provides
    @Singleton
    IStoreProvider provideStoreProvider(Context context){
        return new SPStoreProvider(context);
    }
}
