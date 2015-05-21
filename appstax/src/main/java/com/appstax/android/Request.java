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
        } finally {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Void output) {
        if (callback == null) {
            return;
        } else if (this.result != null) {
            callback.onSuccess(this.result);
        } else {
            callback.onError(this.error);
        }
    }

    protected abstract O run();

}