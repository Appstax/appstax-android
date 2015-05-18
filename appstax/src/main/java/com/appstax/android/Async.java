package com.appstax.android;

import android.os.AsyncTask;

abstract class Async<I, O> extends AsyncTask<I, Void, Response<O>> {

    protected Response<O> perform(I object) {
        try {
            return this.execute(object).get();
        } catch (Exception e) {
            return new Response<O>(e);
        }
    }

    @Override
    protected Response<O> doInBackground(I... objects) {
        try {
            return new Response<O>(apply(objects[0]));
        } catch (Exception e) {
            return new Response<O>(e);
        }
    }

    protected abstract O apply(I object);

}
