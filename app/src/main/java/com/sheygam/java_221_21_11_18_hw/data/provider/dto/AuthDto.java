package com.sheygam.java_221_21_11_18_hw.data.provider.dto;

public class AuthDto {
    private String email;
    private String password;

    public AuthDto() {
    }

    public AuthDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
