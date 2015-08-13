package com.appstax.chatstax;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.appstax.AxChannel;
import com.appstax.AxEvent;
import com.appstax.AxListener;
import com.appstax.AxObject;
import com.appstax.android.Appstax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ChatActivity extends AppCompatActivity {

    protected static final String APPSTAX_KEY = "key";
    protected static final String APPSTAX_URL = "https://appstax.com/api/latest/";

    private Appstax ax;
    private AxChannel channel;
    private List<AxObject> items;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        setViews();
        setListeners();

        ax = new Appstax(APPSTAX_KEY, APPSTAX_URL);

        channel = ax.channel("public/chat", new AxListener() {

            public void onOpen() {
                add(create("Welcome to the chat!"));
            }

            public void onClose() {
                add(create("You lost the connection."));
            }

            public void onMessage(AxEvent event) {
                add(event.getObject());
            }

            public void onError(Exception e) {
                add(create("Something went wrong."));
                e.printStackTrace();
            }

        });
    }

    protected void setViews() {
        items = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdapter = new ChatAdapter(items);
        recyclerView.setAdapter(recyclerAdapter);
    }

    protected void setListeners() {
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = editTextVal(R.id.text);
                clearTextVal(R.id.text);

                if (!text.isEmpty()) {
                    AxObject object = create(text);
                    channel.send(object);
                    add(object);
                }
            }
        });
    }

    protected AxObject create(String text) {
        AxObject object = ax.object("");
        object.put("date", new Date());
        object.put("text", text);
        return object;
    }

    protected void add(AxObject object) {
        if (object != null) {
            items.add(object);
            recyclerAdapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(items.size() - 1);
        }
    }

    protected String editTextVal(int id) {
        EditText view = (EditText) findViewById(id);
        return view.getText().toString();
    }

    protected void clearTextVal(int id) {
        EditText view = (EditText) findViewById(id);
        view.setText("");
    }

}
