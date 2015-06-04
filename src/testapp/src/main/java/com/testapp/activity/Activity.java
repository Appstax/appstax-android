package com.testapp.activity;

import android.os.Bundle;

import com.appstax.android.Appstax;
import com.testapp.R;

public class Activity extends android.app.Activity {

    private static final String APP_KEY = "key";
    private static final String API_URL = "https://appstax.com/api/latest/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Appstax.setAppKey(APP_KEY);
        Appstax.setApiUrl(API_URL);
    }

}
