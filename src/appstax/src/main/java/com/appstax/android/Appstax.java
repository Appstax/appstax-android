package com.appstax.android;

import com.appstax.AxObject;
import com.appstax.AxUser;

import java.util.List;
import java.util.Map;

public abstract class Appstax extends com.appstax.Ax {

    public static void save(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return com.appstax.Ax.save(object);
            }
        };
    }

    public static void remove(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return com.appstax.Ax.remove(object);
            }
        };
    }

    public static void refresh(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return com.appstax.Ax.refresh(object);
            }
        };
    }

    public static void find(final String collection, final String id, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return com.appstax.Ax.find(collection, id);
            }
        };
    }

    public static void find(final String collection, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return com.appstax.Ax.find(collection);
            }
        };
    }

    public static void filter(final String collection, final String filter, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return com.appstax.Ax.filter(collection, filter);
            }
        };
    }

    public static void filter(final String collection, final Map<String, String> properties, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return com.appstax.Ax.filter(collection, properties);
            }
        };
    }

    public static void signup(final String username, final String password, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return com.appstax.Ax.signup(username, password);
            }
        };
    }

    public static void login(final String username, final String password, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return com.appstax.Ax.login(username, password);
            }
        };
    }

    public static void logout(final Callback<Void> callback) {
        new Request<Void>(callback) {
            protected Void run() {
                com.appstax.Ax.logout();
                return null;
            }
        };
    }

    public static void save(final AxUser user, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return com.appstax.Ax.save(user);
            }
        };
    }

    public static void refresh(final AxUser user, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return com.appstax.Ax.refresh(user);
            }
        };
    }

}
