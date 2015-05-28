package com.appstax.basic;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.appstax.AxException;
import com.appstax.AxUser;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;

import java.util.UUID;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set your app key.
        Appstax.setAppKey("YourAppKey");

        // Get username and password from input.
        String username = UUID.randomUUID().toString();
        String password = UUID.randomUUID().toString();

        // Create a new user and log in.
        Appstax.signup(username, password, new Callback<AxUser>() {

            public void onSuccess(AxUser user) {
                showMessage("Welcome", "Hello, " + user.getUsername());
            }

            public void onError(AxException e) {
                showMessage("Error", e.getMessage());
            }

        });
    }

    private void showMessage(String title, String message) {
        final TextView text = (TextView) findViewById(R.id.text);
        this.setTitle(title);
        text.setText(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
