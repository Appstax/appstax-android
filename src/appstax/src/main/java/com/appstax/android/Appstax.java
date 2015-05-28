package com.appstax.android;

import com.appstax.Ax;
import com.appstax.AxFile;
import com.appstax.AxObject;
import com.appstax.AxUser;

import java.util.List;
import java.util.Map;

public abstract class Appstax extends Ax {

    public static void save(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return Ax.save(object);
            }
        };
    }

    public static void remove(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return Ax.remove(object);
            }
        };
    }

    public static void refresh(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return Ax.refresh(object);
            }
        };
    }

    public static void load(final AxFile file, final Callback<AxFile> callback) {
        new Request<AxFile>(callback) {
            protected AxFile run() {
                return Ax.load(file);
            }
        };
    }

    public static void find(final String collection, final String id, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return Ax.find(collection, id);
            }
        };
    }

    public static void find(final String collection, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return Ax.find(collection);
            }
        };
    }

    public static void filter(final String collection, final String filter, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return Ax.filter(collection, filter);
            }
        };
    }

    public static void filter(final String collection, final Map<String, String> properties, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return Ax.filter(collection, properties);
            }
        };
    }

    public static void signup(final String username, final String password, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return Ax.signup(username, password);
            }
        };
    }

    public static void login(final String username, final String password, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return Ax.login(username, password);
            }
        };
    }

    public static void logout(final Callback<Void> callback) {
        new Request<Void>(callback) {
            protected Void run() {
                Ax.logout();
                return null;
            }
        };
    }

    public static void save(final AxUser user, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return Ax.save(user);
            }
        };
    }

    public static void refresh(final AxUser user, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return Ax.refresh(user);
            }
        };
    }

}
