package com.appstax.basic;

import android.app.Activity;
import android.os.Bundle;

import com.appstax.AxException;
import com.appstax.AxUser;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;

import java.util.UUID;


public class MainActivity extends Activity {

    protected static final String APPSTAX_KEY = "YourAppKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Appstax.setAppKey(APPSTAX_KEY);

        String username = UUID.randomUUID().toString();
        String password = UUID.randomUUID().toString();

        Appstax.signup(username, password, new Callback<AxUser>() {

            public void onSuccess(AxUser output) {
                System.out.println("*** Welcome, " + Appstax.getCurrentUser().getUsername());
            }

            public void onError(AxException e) {
                e.printStackTrace();
            }

        });
    }

}
