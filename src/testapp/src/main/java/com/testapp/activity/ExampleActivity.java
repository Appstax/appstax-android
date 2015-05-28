package com.testapp.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appstax.AxException;
import com.appstax.AxObject;
import com.appstax.AxUser;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;
import com.testapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        this.text = (TextView) findViewById(R.id.title);
        this.text.setText(COLLECTION_NAME);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        this.setListAdapter(adapter);

        // Setup Appstax.
        Appstax.setAppKey(APP_KEY);
        Appstax.setApiUrl(API_URL);

        String username = UUID.randomUUID().toString();
        String password = UUID.randomUUID().toString();

        // Create user and make objects.
        Appstax.signup(username, password, new Callback<AxUser>() {
            public void onSuccess(AxUser output) {
                createObject();
                listObjects();
            }
            public void onError(AxException e) {
                e.printStackTrace();
            }
        });
    }

    private void createObject() {
        AxObject object = new AxObject(COLLECTION_NAME);
        object.grantPublic("read", "update");
        Appstax.save(object, null);
        Appstax.refresh(object, null);
    }

    private void listObjects() {
        Appstax.find(COLLECTION_NAME, new Callback<List<AxObject>>() {
            public void onSuccess(List<AxObject> objects) {
                addToList(objects);
            }
            public void onError(AxException e) {
                e.printStackTrace();
            }
        });
    }

    private void addToList(List<AxObject> objects) {
        for (AxObject object : objects) {
            adapter.add(object.getId());
        }
    }

}
