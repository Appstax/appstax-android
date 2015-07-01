package com.appstax.android;

import android.os.Handler;
import android.os.Looper;

import com.appstax.AxEvent;
import com.appstax.AxListener;

class Listener extends AxListener {

    private AxListener listener;

    public Listener(AxListener listener) {
        this.listener = listener;
    }

    @Override
    public void onOpen() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                listener.onOpen();
            }
        });
    }

    @Override
    public void onClose() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                listener.onClose();
            }
        });
    }

    @Override
    public void onMessage(final AxEvent event) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                listener.onMessage(event);
            }
        });
    }

    @Override
    public void onError(final Exception e) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                listener.onError(e);
            }
        });
    }

}
