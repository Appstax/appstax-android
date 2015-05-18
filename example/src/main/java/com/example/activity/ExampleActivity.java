package com.example.activity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appstax.Appstax;
import com.appstax.AppstaxObject;
import com.appstax.android.AppstaxRequest;
import com.appstax.android.AppstaxResponse;
import com.example.R;

import java.util.ArrayList;
import java.util.List;

public class ExampleActivity extends ListActivity {

    private static final String APP_KEY = "YourAppKey";
    private static final String API_URL = "https://appstax.com/api/latest/";
    private static final String COLLECTION_NAME = "YourCollection";

    ArrayList<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example);

        // Setup Appstax.
        Appstax.setAppKey(APP_KEY);
        Appstax.setApiUrl(API_URL);

        // Fetch list of objects.
        AppstaxResponse<List<AppstaxObject>> res = AppstaxRequest.find(COLLECTION_NAME);

        // Show error if any.
        if (res.getError() != null) {
            new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(res.getError().getMessage())
                .show();
            return;
        }

        // Show collection name.
        TextView view = (TextView) findViewById(R.id.title);
        view.setText(COLLECTION_NAME);

        // Create a list view adapter.
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);

        // Add objects to list view.
        for (AppstaxObject object : res.getResult()) {
            adapter.add(object.getId());
        }
    }

}
