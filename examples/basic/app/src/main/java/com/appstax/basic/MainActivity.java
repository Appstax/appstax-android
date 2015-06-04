package com.appstax.basic;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.appstax.AxException;
import com.appstax.AxUser;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;


public class MainActivity extends AppCompatActivity {

    private static final String APPSTAX_KEY = "YourAppKey";
    private static final String APPSTAX_URL = "https://appstax.com/api/latest/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Appstax.setAppKey(APPSTAX_KEY);
        Appstax.setApiUrl(APPSTAX_URL);

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
                message("welcome", Appstax.getCurrentUser().getUsername());
            }
            public void onError(AxException e) {
                message("error", e.getMessage());
            }
        });
    }

    protected void message(String title, String message) {
        new AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setCancelable(true)
            .create().show();
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
