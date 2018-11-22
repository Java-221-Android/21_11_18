package com.sheygam.java_221_21_11_18_hw.data.provider.dto;

public class AuthResponseDto {
    private String token;

    public AuthResponseDto() {
    }

    public AuthResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
