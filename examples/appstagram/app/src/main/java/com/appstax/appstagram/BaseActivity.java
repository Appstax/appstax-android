package com.appstax.appstagram;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.appstax.android.Appstax;

abstract class BaseActivity extends AppCompatActivity {

    protected static final String APPSTAX_KEY = "key";
    protected static final String APPSTAX_URL = "https://appstax.com/api/latest/";
    protected static final String COLLECTION = "ItemCollection";

    protected static final String PREFS_NAME = "appstaxPrefs";
    protected static final String PREF_EMAIL = "email";
    protected static final String PREF_PASSWORD = "password";

    protected static Appstax ax = new Appstax(APPSTAX_KEY, APPSTAX_URL);

    protected void dialog(String title, String message) {
        new AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setCancelable(true)
            .create().show();
    }

    protected void setToolbar() {
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

    protected void logout() {
        clearLoginInfo();
        ax.logout(null);
    }

    protected void saveLoginInfo(String email, String password) {
        getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
            .edit()
            .putString(PREF_EMAIL, email)
            .putString(PREF_PASSWORD, password)
            .commit();
    }

    protected void clearLoginInfo() {
        getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
            .edit()
            .remove(PREF_EMAIL)
            .remove(PREF_PASSWORD)
            .commit();
    }

}
