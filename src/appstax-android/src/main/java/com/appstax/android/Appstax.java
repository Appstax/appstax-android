package com.appstax.android;

import android.app.Activity;
import android.util.Log;

import com.appstax.Ax;
import com.appstax.AxAuthConfig;
import com.appstax.AxAuthResult;
import com.appstax.AxChannel;
import com.appstax.AxFile;
import com.appstax.AxObject;
import com.appstax.AxUser;

import java.util.List;
import java.util.Map;

/**
 * The Appstax class contains all methods that create new Ax* objects,
 * as well as all methods that result in network requests.
 */
public class Appstax extends Ax {

    /**
     * Create a new instance to communicate with the server.
     */
    public Appstax(String key) {
        super(key);
    }

    /**
     * Create a new instance to communicate with the server, using a custom API URL.
     */
    public Appstax(String key, String url) {
        super(key, url);
    }

    /**
     * Create a new WebSocket channel.
     */
    public AxChannel channel(String name) {
        return super.channel(name);
    }

    /**
     * Save an AxObject on the server.
     */
    public void save(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return save(object);
            }
        };
    }

    /**
     * Save an AxObject and all its related objects on the server.
     */
    public void saveAll(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return saveAll(object);
            }
        };
    }

    /**
     * Remove an AxObject on the server.
     */
    public void remove(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return remove(object);
            }
        };
    }

    /**
     * Reload all the properties of an AxObject from the server.
     */
    public void refresh(final AxObject object, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return refresh(object);
            }
        };
    }

    /**
     * Load the actual content of an AxFile from the server.
     */
    public void load(final AxFile file, final Callback<AxFile> callback) {
        new Request<AxFile>(callback) {
            protected AxFile run() {
                return load(file);
            }
        };
    }

    /**
     * Find all the objects in a collection.
     */
    public void find(final String collection, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return find(collection);
            }
        };
    }

    /**
     * Find all the objects in a collection, and expand related objects to the given depth.
     */
    public void find(final String collection, final int depth, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return find(collection, depth);
            }
        };
    }

    /**
     * Find an object based on id in a collection.
     */
    public void find(final String collection, final String id, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return find(collection, id);
            }
        };
    }

    /**
     * Find an object based on id in a collection, and expand related objects to the given depth.
     */
    public void find(final String collection, final String id, final int depth, final Callback<AxObject> callback) {
        new Request<AxObject>(callback) {
            protected AxObject run() {
                return find(collection, id, depth);
            }
        };
    }

    /**
     * Find all objects in a collection that matches the given filter string.
     */
    public void filter(final String collection, final String filter, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return filter(collection, filter);
            }
        };
    }

    /**
     * Find all objects in a collection that matches the given properties.
     */
    public void filter(final String collection, final Map<String, String> properties, final Callback<List<AxObject>> callback) {
        new Request<List<AxObject>>(callback) {
            protected List<AxObject> run() {
                return filter(collection, properties);
            }
        };
    }

    /**
     * Create and login a new user with the given username and password.
     */
    public void signup(final String username, final String password, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return signup(username, password);
            }
        };
    }

    /**
     * Login to the account of an existing user, with the given username and password.
     */
    public void login(final String username, final String password, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return login(username, password);
            }
        };
    }

    /**
     * Log in with a third party auth provider
     */
    public void loginWithProvider(final String provider, final Activity activity, final Callback<AxUser> callback) {
        final AuthDialog dialog = new AuthDialog();
        new Request<Void>(null) {
            @Override
            protected Void run() {
                AxAuthConfig config = getAuthConfig(provider);
                dialog.run(config, activity.getFragmentManager(), new Callback<AxAuthResult>() {
                    @Override
                    public void onSuccess(AxAuthResult authResult) {
                        loginWithProvider(provider, authResult, callback);
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
                return null;
            }
        };
    }

    /**
     * Log in with auth code from a third party auth provider
     */
    private void loginWithProvider(final String provider, final AxAuthResult result, Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            @Override
            protected AxUser run() {
                return loginWithProvider(provider, result);
            }
        };
    }

    /**
     * Logout the current user.
     */
    public void logout(final Callback<Void> callback) {
        new Request<Void>(callback) {
            protected Void run() {
                logout();
                return null;
            }
        };
    }

    /**
     * Send password reset email
     */
    public void requestPasswordReset(final String email, final Callback<Void> callback) {
        new Request<Void>(callback) {
            protected Void run() {
                requestPasswordReset(email);
                return null;
            }
        };
    }

    /**
     * Change password with reset code
     */
    public void changePassword(final String username, final String password, final String code, final boolean login, final Callback<AxUser> callback) {
        new Request<AxUser>(callback) {
            protected AxUser run() {
                return changePassword(username, password, code, login);
            }
        };
    }

}
