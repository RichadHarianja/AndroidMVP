package com.example.richardharianja.androidproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.richardharianja.androidproject.R;
import com.example.richardharianja.androidproject.model.LoginModel;
import com.example.richardharianja.androidproject.presenter.LoginPresenter;
import com.example.richardharianja.androidproject.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    //    Initialize id
    EditText editText_login_username, editText_login_password;
    Button button_login;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editText_login_username = findViewById(R.id.editText_login_username);
        editText_login_password = findViewById(R.id.editText_login_password);
        button_login = findViewById(R.id.button_login);

        button_login.setOnClickListener(this);

        mLoginPresenter = new LoginModel(LoginActivity.this);
    }

    @Override
    public void onClick(View login){
        String username = editText_login_username.getText().toString();
        String password = editText_login_password.getText().toString();
        mLoginPresenter.performLogin(username, password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(), "Please Input Username and Password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, HomeActivity.class));

    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
    }
}

