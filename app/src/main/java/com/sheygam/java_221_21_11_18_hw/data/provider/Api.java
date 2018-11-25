package com.sheygam.java_221_21_11_18_hw.data.provider;

import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.AuthResponseDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.BaseContactDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.ContactListDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.DeleteContactResponseDto;
import com.sheygam.java_221_21_11_18_hw.data.provider.dto.FullContactDto;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {

    @POST("api/registration")
    Call<AuthResponseDto> registration(@Body AuthDto auth);

    @POST("api/login")
    Call<AuthResponseDto> login(@Body AuthDto auth);

    @GET("api/contact")
    Call<ContactListDto> getAllContacts();

    @POST("api/contact")
    Call<FullContactDto> addContact(@Body BaseContactDto contact);

    @PUT("api/contact")
    Call<FullContactDto> updateContact(@Body FullContactDto contact);

    @DELETE("api/contact/{id}")
    Call<DeleteContactResponseDto> deleteContact(@Path("id") Long id);
}
