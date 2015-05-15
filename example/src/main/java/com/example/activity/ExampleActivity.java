package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.appstax.Appstax;
import com.appstax.AppstaxObject;
import com.appstax.android.AppstaxRequest;
import com.appstax.android.AppstaxResponse;
import com.example.R;

public class ExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example);

        Appstax.setAppKey("YourApiKey");
        Appstax.setApiUrl("https://appstax.com/api/latest/");

        AppstaxObject object = new AppstaxObject("BlankCollection");
        AppstaxResponse<AppstaxObject> res = AppstaxRequest.save(object);

        if (res.getError() != null) {
            message(res.getError().getMessage());
            return;
        }

        message(object.getId());
    }

    private void message(String text) {
        TextView view = (TextView) findViewById(R.id.text);
        view.setText(text);
    }

}
