package com.appstax.basic;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.appstax.android.Appstax;

abstract class BaseActivity extends AppCompatActivity {

    private static final String APPSTAX_KEY = "YourAppKey";
    private static final String APPSTAX_URL = "https://appstax.com/api/latest/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Appstax.setAppKey(APPSTAX_KEY);
        Appstax.setApiUrl(APPSTAX_URL);
    }

    protected void dialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .create().show();
    }

}
