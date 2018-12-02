package com.sheygam.java_221_21_11_18_hw.business.login;

import io.reactivex.Completable;

public interface RxILoginInteractor {
    Completable login(String email, String password);
    Completable registration(String email, String password);
}
