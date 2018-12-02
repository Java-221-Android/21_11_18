package com.sheygam.java_221_21_11_18_hw.data.provider;

import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthResponseDto;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiV2 {

    @POST("api/registration")
    Single<Response<AuthResponseDto>> registration(@Body AuthDto auth);

    @POST("api/login")
    Single<Response<AuthResponseDto>> login(@Body AuthDto auth);
}
