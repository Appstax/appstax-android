package com.example.activity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appstax.AppstaxObject;
import com.appstax.android.*;
import com.example.R;

import java.util.ArrayList;
import java.util.List;

public class ExampleActivity extends ListActivity {

    private static final String APP_KEY = "YourAppKey";
    private static final String API_URL = "https://appstax.com/api/latest/";
    private static final String COLLECTION_NAME = "BlankCollection";

    ArrayList<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example);

        // Setup activity.
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        this.setListAdapter(adapter);
        this.text = (TextView) findViewById(R.id.title);
        this.text.setText(COLLECTION_NAME);

        // Setup Appstax.
        Appstax.setAppKey(APP_KEY);
        Appstax.setApiUrl(API_URL);

        // New object.
        AppstaxObject object = new AppstaxObject(COLLECTION_NAME);

        // Save object, without callback.
        Appstax.save(object, null);

        // Find all objects in collection.
        Appstax.find(COLLECTION_NAME, new Callback<List<AppstaxObject>>() {
            public void fail(Exception e) {
                showMessage("error", e.getMessage());
            }
            public void done(List<AppstaxObject> objects) {
                addToList(objects);
            }
        });

    }

    private void showMessage(String title, String message) {
        new AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .show();
    }

    private void addToList(List<AppstaxObject> objects) {
        for (AppstaxObject object : objects) {
            adapter.add(object.getId());
        }
    }

}
