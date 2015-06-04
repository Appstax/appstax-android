package com.appstax.basic;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.appstax.AxException;
import com.appstax.AxUser;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;


public class SignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signup();
            }
        });
    }

    protected void signup() {
        Appstax.signup(email(), password(), new Callback<AxUser>() {
            public void onSuccess(AxUser output) {
                dialog("welcome", Appstax.getCurrentUser().getUsername());
            }
            public void onError(AxException e) {
                dialog("error", e.getMessage());
            }
        });
    }

    protected String email() {
        EditText view = (EditText) findViewById(R.id.email);
        return view.getText().toString();
    }

    protected String password() {
        EditText view = (EditText) findViewById(R.id.password);
        return view.getText().toString();
    }

}
