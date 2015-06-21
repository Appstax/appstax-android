package com.testapp.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.appstax.AxException;
import com.appstax.AxFile;
import com.appstax.AxObject;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;

import java.util.List;

@LargeTest
public class ActivityEspressoTest extends ActivityInstrumentationTestCase2<Activity> {

    private static final String APP_KEY_1 = "YourApiKey";
    private static final String APP_KEY_2 = "SomeAppKey";
    private static final String API_URL_1 = com.appstax.Ax.getApiUrl();
    private static final String COLLECTION = "BlankCollection";

    public ActivityEspressoTest() {
        super(Activity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
        Appstax.setAppKey(APP_KEY_1);
        Appstax.setApiUrl(API_URL_1);
    }

    public void testAppKey() {
        assertEquals(APP_KEY_1, Appstax.getAppKey());
        Appstax.setAppKey(APP_KEY_2);
        assertEquals(APP_KEY_2, Appstax.getAppKey());
    }

    public void testApiUrl() {
        assertEquals(API_URL_1, Appstax.getApiUrl());
    }

    public void testObjectCreate() {
        AxObject object = new AxObject(COLLECTION);
        object.put("title", "hello");
        object.put("count", 42);
        assertEquals(COLLECTION, object.getCollection());
        assertEquals("hello", object.get("title"));
        assertEquals(42, object.get("count"));
    }

    public void testFileCreate() {
        AxObject object = new AxObject(COLLECTION);
        AxFile file = new AxFile("123", "123".getBytes());
        object.put("file", file);
        assertNull(object.getId());
        assertNotNull(object.getFile("file").getName());
        assertNull(object.getFile("file").getUrl());
    }

    public void testObjectSave() {
        Appstax.save(new AxObject(COLLECTION), new Callback<AxObject>() {
            public void onSuccess(AxObject output) {
                assertTrue(false);
            }

            public void onError(AxException e) {
                assertTrue(e.getMessage().startsWith("Not authorized."));
            }
        });
    }

    public void testObjectFind() {
        Appstax.find(COLLECTION, 123, new Callback<List<AxObject>>() {
            public void onSuccess(List<AxObject> output) {
                assertTrue(false);
            }

            public void onError(AxException e) {
                assertTrue(e.getMessage().startsWith("Not authorized."));
            }
        });
    }

    public void testObjectRemove() {
        Appstax.remove(new AxObject(COLLECTION), new Callback<AxObject>() {
            public void onSuccess(AxObject output) {
                assertTrue(false);
            }

            public void onError(AxException e) {
                assertTrue(e.getMessage().startsWith("Not authorized."));
            }
        });
    }

    public void testObjectFilter() {
        Appstax.filter(COLLECTION, "Age > 42", new Callback<List<AxObject>>() {
            public void onSuccess(List<AxObject> output) {
                assertTrue(false);
            }
            public void onError(AxException e) {
                assertTrue(e.getMessage().startsWith("Not authorized."));
            }
        });
    }

}
