package com.appstax.android;

import com.appstax.AppstaxObject;
import com.appstax.AppstaxUser;

import java.util.List;
import java.util.Map;

public abstract class Appstax extends com.appstax.Appstax {

    public static void save(final AppstaxObject object, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject run() {
                return com.appstax.Appstax.save(object);
            }
        };
    }

    public static void remove(final AppstaxObject object, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject run() {
                return com.appstax.Appstax.remove(object);
            }
        };
    }

    public static void refresh(final AppstaxObject object, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject run() {
                return com.appstax.Appstax.refresh(object);
            }
        };
    }

    public static void find(final String collection, final String id, final Callback<AppstaxObject> callback) {
        new Request<AppstaxObject>(callback) {
            protected AppstaxObject run() {
                return com.appstax.Appstax.find(collection, id);
            }
        };
    }

    public static void find(final String collection, final Callback<List<AppstaxObject>> callback) {
        new Request<List<AppstaxObject>>(callback) {
            protected List<AppstaxObject> run() {
                return com.appstax.Appstax.find(collection);
            }
        };
    }

    public static void filter(final String collection, final String filter, final Callback<List<AppstaxObject>> callback) {
        new Request<List<AppstaxObject>>(callback) {
            protected List<AppstaxObject> run() {
                return com.appstax.Appstax.filter(collection, filter);
            }
        };
    }

    public static void filter(final String collection, final Map<String, String> properties, final Callback<List<AppstaxObject>> callback) {
        new Request<List<AppstaxObject>>(callback) {
            protected List<AppstaxObject> run() {
                return com.appstax.Appstax.filter(collection, properties);
            }
        };
    }

    public static void signup(final String username, final String password, final Callback<AppstaxUser> callback) {
        new Request<AppstaxUser>(callback) {
            protected AppstaxUser run() {
                return com.appstax.Appstax.signup(username, password);
            }
        };
    }

    public static void login(final String username, final String password, final Callback<AppstaxUser> callback) {
        new Request<AppstaxUser>(callback) {
            protected AppstaxUser run() {
                return com.appstax.Appstax.login(username, password);
            }
        };
    }

    public static void logout(final Callback<Void> callback) {
        new Request<Void>(callback) {
            protected Void run() {
                com.appstax.Appstax.logout();
                return null;
            }
        };
    }

    public static void save(final AppstaxUser user, final Callback<AppstaxUser> callback) {
        new Request<AppstaxUser>(callback) {
            protected AppstaxUser run() {
                return com.appstax.Appstax.save(user);
            }
        };
    }

    public static void refresh(final AppstaxUser user, final Callback<AppstaxUser> callback) {
        new Request<AppstaxUser>(callback) {
            protected AppstaxUser run() {
                return com.appstax.Appstax.refresh(user);
            }
        };
    }

}
