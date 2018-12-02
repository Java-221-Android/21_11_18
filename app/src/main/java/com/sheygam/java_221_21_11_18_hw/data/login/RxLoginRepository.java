package com.sheygam.java_221_21_11_18_hw.data.login;

import android.util.Log;

import com.sheygam.java_221_21_11_18_hw.data.provider.ApiV2;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthResponseDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.IStoreProvider;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Response;

public class RxLoginRepository implements RxILoginRepository{
    private ApiV2 api;
    private IStoreProvider storeProvider;

    public RxLoginRepository(ApiV2 api, IStoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public Completable login(String email, String password) {

        return Completable.fromSingle(api.login(new AuthDto(email,password))
                .onErrorResumeNext(response -> Single.error(new Exception("Connection error!")))
                .doOnSuccess(this::success)
        );
    }

    @Override
    public Completable registration(String email, String password) {
        return Completable.fromSingle(api.registration(new AuthDto(email,password))
                .onErrorResumeNext(response -> Single.error(new Exception("Connection error!")))
                .doOnSuccess(this::success)
        );
    }



    private void success(Response<AuthResponseDto> authResponseDtoResponse) throws Exception {
        if(authResponseDtoResponse.isSuccessful()){
            AuthResponseDto auth = authResponseDtoResponse.body();
            storeProvider.saveToken(auth.getToken());
        }else if(authResponseDtoResponse.code() == 409){
            throw new Exception("User already exists!");
        }else if(authResponseDtoResponse.code() == 401){
            throw new Exception("Wrong credentials!");
        }else{
            Log.d("TAG", "success() server error: " + authResponseDtoResponse.errorBody().string());
            throw new Exception("Server error! Call to support!");
        }
    }
}
