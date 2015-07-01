package com.appstax.basic;

import android.app.Activity;
import android.os.Bundle;

import com.appstax.android.Appstax;


public class MainActivity extends Activity {

    private Appstax ax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ax = new Appstax("key");
    }

}
