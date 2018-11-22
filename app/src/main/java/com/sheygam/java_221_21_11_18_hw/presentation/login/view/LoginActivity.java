package com.sheygam.java_221_21_11_18_hw.presentation.login.view;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.sheygam.java_221_21_11_18_hw.R;
import com.sheygam.java_221_21_11_18_hw.presentation.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MvpAppCompatActivity implements ILoginView{

    @BindView(R.id.inputWrapper) LinearLayout inputWrapper;
    @BindView(R.id.inputEmail)EditText inputEmail;
    @BindView(R.id.inputPassword)EditText inputPassword;
    @BindView(R.id.loginBtn)Button loginBtn;
    @BindView(R.id.regBtn)Button regBtn;
    @BindView(R.id.myProgress)ProgressBar myProgress;

    @InjectPresenter
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginBtn)
    public void onLoginClicked(){
        presenter.onLogin(inputEmail.getText().toString(), inputPassword.getText().toString());
    }

    @OnClick(R.id.regBtn)
    public void onRegistrationClicked(){
        presenter.onRegistration(inputEmail.getText().toString(), inputPassword.getText().toString());
    }


    @Override
    public void showProgress() {
        inputWrapper.setVisibility(View.GONE);
        myProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        inputWrapper.setVisibility(View.VISIBLE);
        myProgress.setVisibility(View.GONE);
    }

    @Override
    public void showEmailValidError(String error) {
        inputEmail.setError(error);
    }

    @Override
    public void showPassValidError(String error) {
        inputPassword.setError(error);
    }

    @Override
    public void showNextView() {
        Toast.makeText(this, "Auth ok", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAuthError(String error) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setPositiveButton("Ok",null)
                .setCancelable(false)
                .setMessage(error)
                .create()
                .show();
    }
}
