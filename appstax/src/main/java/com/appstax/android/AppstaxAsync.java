package com.appstax.android;

import android.os.AsyncTask;

abstract class AppstaxAsync<I, O> extends AsyncTask<I, Void, AppstaxResponse<O>> {

    @Override
    protected AppstaxResponse<O> doInBackground(I... objects) {
        try {
            return new AppstaxResponse<O>(apply(objects[0]));
        } catch (Exception e) {
            return new AppstaxResponse<O>(e);
        }
    }

    protected abstract O apply(I object);

}
