package com.appstax.android;

import android.os.AsyncTask;

import com.appstax.AppstaxObject;
import com.appstax.exceptions.AppstaxRequestException;

public class AppstaxRequest {

    public static AppstaxResponse<AppstaxObject> save(AppstaxObject object) {
        try {
            return new AppstaxSaveAsyncTask().execute(object).get();
        } catch (Exception e) {
            return new AppstaxResponse<AppstaxObject>(e);
        }
    }

    private static class AppstaxSaveAsyncTask extends AsyncTask<AppstaxObject, Void, AppstaxResponse<AppstaxObject>> {
        @Override
        protected AppstaxResponse<AppstaxObject> doInBackground(AppstaxObject... objects) {
            try {
                objects[0].save();
            } catch (AppstaxRequestException e) {
                return new AppstaxResponse<AppstaxObject>(e);
            }
            return new AppstaxResponse<AppstaxObject>(objects[0]);
        }
    }

}
