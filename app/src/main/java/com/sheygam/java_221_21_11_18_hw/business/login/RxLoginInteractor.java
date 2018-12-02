package com.sheygam.java_221_21_11_18_hw.business.login;

import com.sheygam.java_221_21_11_18_hw.data.login.RxILoginRepository;

import io.reactivex.Completable;

public class RxLoginInteractor  implements RxILoginInteractor{
    private RxILoginRepository repository;

    public RxLoginInteractor(RxILoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public Completable login(String email, String password) {
        try {
            validEmail(email);
            validPassword(password);
        } catch (PasswordValidException|EmailValidException e) {
            return Completable.error(e);
        }
        return repository.login(email,password);
    }

    @Override
    public Completable registration(String email, String password){
        try {
            validEmail(email);
            validPassword(password);
        }catch (PasswordValidException|EmailValidException e){
            return Completable.error(e);
        }
        return repository.registration(email,password);
    }

    private void validEmail(String email) throws EmailValidException {
        if(!email.contains("@")){
            throw new EmailValidException("Email must have @!");
        }
    }

    private void validPassword(String password) throws PasswordValidException {
        if(password.length() < 8){
            throw new PasswordValidException("Password minimum 8 symbols!");
        }
    }
}
