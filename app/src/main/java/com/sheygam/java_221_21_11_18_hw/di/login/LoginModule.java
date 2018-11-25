package com.sheygam.java_221_21_11_18_hw.di.login;

import com.sheygam.java_221_21_11_18_hw.business.login.ILoginInteractor;
import com.sheygam.java_221_21_11_18_hw.business.login.LoginInteractor;
import com.sheygam.java_221_21_11_18_hw.data.login.ILoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.login.LoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.provider.Api;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.IStoreProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    @LoginScope
    ILoginRepository provideLoginRepository(Api api, IStoreProvider storeProvider){
        return new LoginRepository(api, storeProvider);
    }

    @Provides
    @LoginScope
    ILoginInteractor provideLoginInteractor(ILoginRepository repository){
        return new LoginInteractor(repository);
    }
}
