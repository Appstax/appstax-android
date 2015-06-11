package com.appstax.basic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appstax.android.Appstax;


public class SignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        createToolbar();

        Appstax.logout(null);

        Button signupButton = (Button) findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signup(
                    editTextVal(R.id.email),
                    editTextVal(R.id.password)
                );
            }
        });
    }

}
