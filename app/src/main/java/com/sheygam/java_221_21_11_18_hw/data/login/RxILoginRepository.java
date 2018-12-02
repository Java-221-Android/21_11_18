package com.sheygam.java_221_21_11_18_hw.data.login;

import io.reactivex.Completable;

public interface RxILoginRepository {
    Completable login(String email, String password);
    Completable registration(String email, String password);
}
