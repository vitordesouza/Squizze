package com.catorze.squizze.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.catorze.squizze.R;
import com.catorze.squizze.domain.Category;
import com.catorze.squizze.domain.User;
import com.catorze.squizze.domain.dto.AuthCallback;
import com.catorze.squizze.rest.AbstractRestService;
import com.catorze.squizze.rest.LoginRestService;
import com.catorze.squizze.rest.exception.HttpRestException;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn, signupbtn;
    EditText strUser, strPass;
    User user;
    private LoginRestService service;

    @Override
    protected void onStart() {
        super.onStart();
        service = new LoginRestService(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        signupbtn = (Button) findViewById(R.id.signupbtn);
        strUser = (EditText) findViewById(R.id.user);
        strPass = (EditText) findViewById(R.id.pass);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User(strUser.getText().toString(), strPass.getText().toString());
                service.post(user, new AbstractRestService.OnResponse<AuthCallback>() {
                    @Override
                    public void success(AuthCallback authCallback) {
                        callCategoryActivity();
                    }

                    @Override
                    public void error(HttpRestException restException) {

                    }
                });
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }

    private void callCategoryActivity() {
        Intent i = new Intent(this, CategoryActivity.class);
        startActivity(i);
        finish();
    }

    public void login(View view) {

    }
}
