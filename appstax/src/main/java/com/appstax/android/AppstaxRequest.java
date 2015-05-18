package com.appstax.android;

import com.appstax.AppstaxObject;

import java.util.List;

public class AppstaxRequest {

    public static AppstaxResponse<List<AppstaxObject>> find(String collection) {
        try {
            return new FindAsync().execute(collection).get();
        } catch (Exception e) {
            return new AppstaxResponse<List<AppstaxObject>>(e);
        }
    }

    private static class FindAsync extends AppstaxAsync<String,List<AppstaxObject>> {
        protected List<AppstaxObject> apply(String collection) {
            return AppstaxObject.find(collection);
        }
    }

    public static AppstaxResponse<AppstaxObject> save(AppstaxObject object) {
        try {
            return new SaveAsync().execute(object).get();
        } catch (Exception e) {
            return new AppstaxResponse<AppstaxObject>(e);
        }
    }

    private static class SaveAsync extends AppstaxAsync<AppstaxObject, AppstaxObject> {
        protected AppstaxObject apply(AppstaxObject object) {
            object.save();
            return object;
        }
    }

}

