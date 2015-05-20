package com.appstax.android;

import com.appstax.AppstaxObject;
import java.util.List;

public abstract class Appstax extends com.appstax.Appstax {

    public static void find(final String collection, final Callback<List<AppstaxObject>> callback) {
        new Request<List<AppstaxObject>>(callback) {
            protected List<AppstaxObject> apply() {
                return com.appstax.Appstax.find(collection);
            }
        };
    }

    public static void find(final String collection, final String id, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject apply() {
                return com.appstax.Appstax.find(collection, id);
            }
        };
    }

    public static void save(final AppstaxObject object, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject apply() {
                return com.appstax.Appstax.save(object);
            }
        };
    }

    public static void delete(final AppstaxObject object, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject apply() {
                return com.appstax.Appstax.delete(object);
            }
        };
    }

}
