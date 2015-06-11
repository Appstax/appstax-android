package com.appstax.basic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appstax.android.Appstax;


public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        createToolbar();

        Appstax.logout(null);

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login(
                    editTextVal(R.id.email),
                    editTextVal(R.id.password)
                );
            }
        });
    }

}
