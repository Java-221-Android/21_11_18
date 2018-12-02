package com.sheygam.java_221_21_11_18_hw.di.login;

import com.sheygam.java_221_21_11_18_hw.business.login.RxILoginInteractor;
import com.sheygam.java_221_21_11_18_hw.business.login.RxLoginInteractor;
import com.sheygam.java_221_21_11_18_hw.data.login.RxILoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.login.RxLoginRepository;
import com.sheygam.java_221_21_11_18_hw.data.provider.ApiV2;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.IStoreProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class RxLoginModule {

    @Provides
    @LoginScope
    RxILoginRepository provideRxLoginRepository(ApiV2 api, IStoreProvider storeProvider){
        return new RxLoginRepository(api,storeProvider);
    }

    @Provides
    @LoginScope
    RxILoginInteractor provideRxLoginInteractor(RxILoginRepository repository){
        return new RxLoginInteractor(repository);
    }
}
