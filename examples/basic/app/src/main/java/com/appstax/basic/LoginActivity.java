package com.appstax.basic;

import android.content.SharedPreferences;
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

        if (loginFromSaved()) {
            return;
        }

        setContentView(R.layout.login);
        setToolbar();

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login(
                        editTextVal(R.id.email),
                        editTextVal(R.id.password)
                );
            }
        });

        Button signupButton = (Button) findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(SignupActivity.class);
            }
        });

    }

    protected boolean loginFromSaved() {
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String email = pref.getString(PREF_EMAIL, null);
        String password = pref.getString(PREF_PASSWORD, null);

        if (email != null && password != null) {
            login(email, password);
            return true;
        }

        return false;
    }

    protected void login(final String email, final String password) {
        Appstax.login(email, password, new Callback<AxUser>() {
            public void onSuccess(AxUser output) {
                saveLoginInfo(email, password);
                startActivity(FeedActivity.class);
            }

            public void onError(AxException e) {
                dialog("error", e.getMessage());
            }
        });
    }

}
