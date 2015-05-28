package com.appstax.android;

import android.os.AsyncTask;

import com.appstax.AxException;

abstract class Request<O> extends AsyncTask<Void, Void, Void> {

    private final Callback<O> callback;
    private volatile AxException error;
    private volatile O result;

    public Request(Callback<O> callback) {
        this.callback = callback;
        this.execute();
    }

    @Override
    protected Void doInBackground(Void... input) {
        try {
            this.result = run();
        } catch (AxException e) {
            this.error = e;
        } catch (Exception e) {
            this.error = new AxException(e.getMessage(), e);
        } finally {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Void output) {
        if (callback == null) {
            return;
        } else if (this.error != null) {
            callback.onError(this.error);
        } else {
            callback.onSuccess(this.result);
        }
    }

    protected abstract O run();

}