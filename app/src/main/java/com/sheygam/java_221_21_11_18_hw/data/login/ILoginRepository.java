package com.sheygam.java_221_21_11_18_hw.data.login;

public interface ILoginRepository {
    void login(String email, String password,LoginRepositoryCallback callback);
    void registration(String email, String password,LoginRepositoryCallback callback);
}
