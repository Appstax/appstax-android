package com.appstax.appstagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appstax.AxException;
import com.appstax.AxUser;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;


public class SignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setToolbar();
        logout();

        Button signupButton = (Button) findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signup(
                        editTextVal(R.id.email),
                        editTextVal(R.id.password)
                );
            }
        });

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(LoginActivity.class);
            }
        });
    }

    protected void signup(String email, String password) {
        Appstax.signup(email, password, new Callback<AxUser>() {
            public void onSuccess(AxUser user) {
                saveName(user, editTextVal(R.id.name));
                startActivity(FeedActivity.class);
            }
            public void onError(AxException e) {
                dialog("error", e.getMessage());
            }
        });
    }

    protected void saveName(AxUser user, String name) {
        user.put("name", name);
        Appstax.save(user, null);
    }

}
