package com.appstax.appstagram;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.appstax.AxException;
import com.appstax.AxFile;
import com.appstax.AxObject;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class FeedActivity extends BaseActivity {

    static final int CAMERA_REQUEST = 1;

    private Uri output;
    private List<FeedItem> items;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
        setToolbar();

        // Users have to log in first.
        if (Appstax.getCurrentUser() == null) {
            startActivity(LoginActivity.class);
            return;
        }

        // Set up recycler view for items.
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerManager);

        // Connect it to our list of items.
        items = new ArrayList<FeedItem>();
        recyclerAdapter = new FeedAdapter(items);
        recyclerView.setAdapter(recyclerAdapter);

        // Get items from server.
        refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh) {
            refresh();
            return true;
        }
        if (id == R.id.logout) {
            logout();
            startActivity(LoginActivity.class);
            return true;
        }
        if (id == R.id.add) {
            takePicture();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void refresh() {
        items.clear();
        recyclerAdapter.notifyDataSetChanged();

        Appstax.find(ITEM_COLLECTION, 1, new Callback<List<AxObject>>() {
            public void onSuccess(List<AxObject> output) {
                for (AxObject object : output) {
                    items.add(new FeedItem(object));
                }
                recyclerAdapter.notifyDataSetChanged();
            }

            public void onError(AxException e) {
                dialog("error", e.getMessage());
            }
        });

    }

    protected void takePicture() {
        this.output = getOutputMediaFileUri();
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, this.output);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != CAMERA_REQUEST || resultCode != RESULT_OK) {
            return;
        }

        showLoading();

        String file = UUID.randomUUID().toString() + ".jpg";
        AxObject object = new AxObject(ITEM_COLLECTION);

        object.put("image", new AxFile(file, uriToByteArray(this.output)));
        object.createRelation("user", Appstax.getCurrentUser());

        Appstax.save(object, new Callback<AxObject>() {
            public void onSuccess(AxObject output) {
                hideLoading();
                refresh();
            }
            public void onError(AxException e) {
                hideLoading();
                dialog("error", e.getMessage());
            }
        });
    }

    private static Uri getOutputMediaFileUri(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Appstagram");

        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
            return null;
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_"+ timeStamp + ".jpg");
        return Uri.fromFile(mediaFile);
    }

    public byte[] uriToByteArray(Uri uri) {
        try {
            ContentResolver c = getBaseContext().getContentResolver();
            InputStream inputStream = c.openInputStream(uri);
            Bitmap bmp = BitmapFactory.decodeStream(inputStream);
            ByteArrayOutputStream s = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, s);
            return s.toByteArray();
        } catch (FileNotFoundException e) {
            dialog("error", e.getMessage());
            return null;
        }
    }

}
