package com.appstax.basic;

import android.app.Activity;
import android.os.Bundle;

import com.appstax.android.Appstax;


public class MainActivity extends Activity {

    protected static final String APPSTAX_KEY = "YourAppKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Appstax.setAppKey(APPSTAX_KEY);
    }

}
