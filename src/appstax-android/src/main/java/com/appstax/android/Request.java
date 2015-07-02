package com.appstax.android;

import android.os.AsyncTask;

abstract class Request<O> extends AsyncTask<Void, Void, Void> {

    private final Callback<O> callback;
    private volatile Exception error;
    private volatile O result;

    public Request(Callback<O> callback) {
        this.callback = callback;
        this.execute();
    }

    @Override
    protected Void doInBackground(Void... input) {
        try {
            this.result = run();
        } catch (Exception e) {
            this.error = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void output) {
        if (callback != null) {
            if (this.error != null) {
                callback.onError(this.error);
            } else {
                callback.onSuccess(this.result);
            }
        }
    }

    protected abstract O run();

}