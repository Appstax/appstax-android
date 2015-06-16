package com.appstax.appstagram;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.appstax.AxException;
import com.appstax.AxFile;
import com.appstax.AxObject;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class FeedItem {

    private AxObject object;

    FeedItem(AxObject object) {
        this.object = object;
    }

    public String getTitle() {
        return object.get("title").toString();
    }

    public String getSubtitle() {
        String date = object.get("sysCreated").toString();
        DateFormat source = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        DateFormat target = new SimpleDateFormat("MMMM dd @ HH:mm");

        try {
            return target.format(source.parse(date));
        } catch (ParseException e) {
            return "";
        }
    }

    public void getImage(final ImageView image) {
        AxFile file = object.getFile("image");

        if (file.getData() != null) {
            setData(image, file.getData());
            return;
        }

        Appstax.load(file, new Callback<AxFile>() {
            public void onSuccess(AxFile output) {
                setData(image, output.getData());
            }
            public void onError(AxException e) {
                e.printStackTrace();
            }
        });
    }

    private void setData(final ImageView image, byte[] data) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        image.setImageBitmap(bitmap);
    }

}
