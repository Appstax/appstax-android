package com.appstax.android;

import com.appstax.Ax;
import com.appstax.AxChannel;
import com.appstax.AxFile;
import com.appstax.AxListener;
import com.appstax.AxObject;
import com.appstax.AxUser;

import java.util.List;
import java.util.Map;

public class Appstax extends Ax {

    public Appstax(String key) {
        super(key);
    }

    public Appstax(String key, String url) {
        super(key, url);
    }

    public AxChannel channel(String name, AxListener listener) {
        return super.channel(name, new Listener(listener));
    }

    public void save(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return save(object);
            }
        };
    }

    public void saveAll(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return saveAll(object);
            }
        };
    }

    public void remove(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return remove(object);
            }
        };
    }

    public void refresh(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return refresh(object);
            }
        };
    }

    public void load(final AxFile file, final Callback<AxFile> callback) {
        new Request<AxFile>(callback) {
            protected AxFile run() {
                return load(file);
            }
        };
    }

    public void find(final String collection, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return find(collection);
            }
        };
    }

    public void find(final String collection, final int depth, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return find(collection, depth);
            }
        };
    }

    public void find(final String collection, final String id, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return find(collection, id);
            }
        };
    }

    public void find(final String collection, final String id, final int depth, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return find(collection, id, depth);
            }
        };
    }

    public void filter(final String collection, final String filter, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return filter(collection, filter);
            }
        };
    }

    public void filter(final String collection, final Map<String, String> properties, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return filter(collection, properties);
            }
        };
    }

    public void signup(final String username, final String password, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return signup(username, password);
            }
        };
    }

    public void login(final String username, final String password, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return login(username, password);
            }
        };
    }

    public void logout(final Callback<Void> callback) {
        new Request<Void>(callback) {
            protected Void run() {
                logout();
                return null;
            }
        };
    }

}
