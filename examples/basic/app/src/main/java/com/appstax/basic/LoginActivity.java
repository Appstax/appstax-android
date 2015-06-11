package com.appstax.basic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appstax.AxException;
import com.appstax.AxUser;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;


public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        createToolbar();

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });
    }

    protected void login() {
        Appstax.signup(editTextVal(R.id.email), editTextVal(R.id.password), new Callback<AxUser>() {
            public void onSuccess(AxUser output) {
                dialog("welcome back", Appstax.getCurrentUser().getUsername());
            }

            public void onError(AxException e) {
                dialog("error", e.getMessage());
            }
        });
    }

}
