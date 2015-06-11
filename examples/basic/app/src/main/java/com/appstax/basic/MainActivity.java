package com.appstax.basic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        createToolbar();

        Button signupButton = (Button) findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(SignupActivity.class);
            }
        });

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(LoginActivity.class);
            }
        });
    }

}
