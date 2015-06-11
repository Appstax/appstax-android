package com.appstax.basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

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

    protected void createToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void startActivity(Class c) {
        startActivity(new Intent(getApplicationContext(), c));
    }

    protected String editTextVal(int id) {
        EditText view = (EditText) findViewById(id);
        return view.getText().toString();
    }

}
