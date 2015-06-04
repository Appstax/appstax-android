package com.appstax.basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.appstax.*;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set your app key.
        Appstax.setAppKey("YourAppKey");

        // Get username and password from input.
        String username = UUID.randomUUID().toString();
        String password = UUID.randomUUID().toString();

        // Create a new user and log in.
        Appstax.signup(username, password, new Callback<AxUser>() {
            public void onSuccess(AxUser user) {
                showMessage("Hello, " + Appstax.getCurrentUser().getUsername());
            }

            public void onError(AxException e) {
                showMessage(e.getMessage());
            }
        });
    }

    private void showMessage(String message) {
        final TextView text = (TextView) findViewById(R.id.text);
        text.setText(message);
    }

}
