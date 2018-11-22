package com.sheygam.java_221_21_11_18_hw.data.provider;

import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthResponseDto;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("api/registration")
    Response<AuthResponseDto> registration(@Body AuthDto auth);

    @POST("api/login")
    Response<AuthResponseDto> login(@Body AuthDto auth);
}
