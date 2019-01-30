package com.example.richardharianja.androidproject.model;

import android.text.TextUtils;

import com.example.richardharianja.androidproject.presenter.LoginPresenter;
import com.example.richardharianja.androidproject.view.LoginView;

public class LoginModel implements LoginPresenter {
    LoginView mLoginView;

    public LoginModel(LoginView loginView){
        this.mLoginView = loginView;
    }

    @Override
    public void performLogin(String username, String password){
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mLoginView.loginValidations();
        } else {
            if (username.equals("Richad") && password.equals("richad123")){
                mLoginView.loginSuccess();
            } else {
                mLoginView.loginError();
            }
        }
    }
}
