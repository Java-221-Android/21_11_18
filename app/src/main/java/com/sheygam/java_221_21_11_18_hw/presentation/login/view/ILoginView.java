package com.sheygam.java_221_21_11_18_hw.presentation.login.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface ILoginView extends MvpView {
    public void showProgress();
    public void hideProgress();
    public void showEmailValidError(String error);
    public void showPassValidError(String error);
    public void showNextView();
    public void showAuthError(String error);
}
