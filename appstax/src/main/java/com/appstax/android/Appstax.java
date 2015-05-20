package com.appstax.android;

import com.appstax.AppstaxObject;
import java.util.List;
import java.util.Map;

public abstract class Appstax extends com.appstax.Appstax {

    public static void save(final AppstaxObject object, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject apply() {
                return com.appstax.Appstax.save(object);
            }
        };
    }

    public static void remove(final AppstaxObject object, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject apply() {
                return com.appstax.Appstax.remove(object);
            }
        };
    }

    public static void refresh(final AppstaxObject object, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject apply() {
                return com.appstax.Appstax.refresh(object);
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

    public static void find(final String collection, final Callback<List<AppstaxObject>> callback) {
        new Request<List<AppstaxObject>>(callback) {
            protected List<AppstaxObject> apply() {
                return com.appstax.Appstax.find(collection);
            }
        };
    }

    public static void filter(final String collection, final String filter, final Callback<List<AppstaxObject>> callback) {
        new Request<List<AppstaxObject>>(callback) {
            protected List<AppstaxObject> apply() {
                return com.appstax.Appstax.filter(collection, filter);
            }
        };
    }

    public static void filter(final String collection, final Map<String, String> properties, final Callback<List<AppstaxObject>> callback) {
        new Request<List<AppstaxObject>>(callback) {
            protected List<AppstaxObject> apply() {
                return com.appstax.Appstax.filter(collection, properties);
            }
        };
    }

}
