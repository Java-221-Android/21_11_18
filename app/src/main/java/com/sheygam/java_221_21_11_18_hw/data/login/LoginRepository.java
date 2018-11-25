package com.sheygam.java_221_21_11_18_hw.data.login;

import android.util.Log;

import com.sheygam.java_221_21_11_18_hw.data.provider.Api;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthResponseDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.store.IStoreProvider;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository implements ILoginRepository {
    private static final String TAG = "MY_TAG";
    private Api api;
    private IStoreProvider storeProvider;

    public LoginRepository(Api api, IStoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public void login(String email, String password, LoginRepositoryCallback callback) {
        AuthDto authDto = new AuthDto(email,password);
        api.login(authDto).enqueue(new Callback<AuthResponseDto>() {
            @Override
            public void onResponse(Call<AuthResponseDto> call, Response<AuthResponseDto> response) {
                if(response.isSuccessful()){
                    AuthResponseDto authResponse = response.body();
                    storeProvider.saveToken(authResponse.getToken());
                    callback.loginSuccess();
                }else if(response.code() == 401){
                    callback.loginFailure("Wrong email or password");
                }else{
                    try {
                        Log.d(TAG, "onResponse error: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    callback.loginFailure("Server error! Call to support!");
                }
            }

            @Override
            public void onFailure(Call<AuthResponseDto> call, Throwable t) {
                callback.loginFailure("Connection error! Check your internet!");
            }
        });
    }

    @Override
    public void registration(String email, String password, LoginRepositoryCallback callback) {
        AuthDto authDto = new AuthDto(email,password);
        api.registration(authDto).enqueue(new Callback<AuthResponseDto>() {
            @Override
            public void onResponse(Call<AuthResponseDto> call, Response<AuthResponseDto> response) {
                if(response.isSuccessful()){
                    AuthResponseDto authResponse = response.body();
                    storeProvider.saveToken(authResponse.getToken());
                    callback.registrationSuccess();
                }else if(response.code() == 409){
                    callback.registrationFailure("User already exist!");
                }else{
                    try {
                        Log.d(TAG, "onResponse error: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    callback.registrationFailure("Server error! Call to support!");
                }
            }

            @Override
            public void onFailure(Call<AuthResponseDto> call, Throwable t) {
                callback.registrationFailure("Connection error! Check your internet!");
            }
        });
    }
}
