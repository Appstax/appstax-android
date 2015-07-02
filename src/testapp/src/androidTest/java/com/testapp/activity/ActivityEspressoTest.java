package com.testapp.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.appstax.AxFile;
import com.appstax.AxListener;
import com.appstax.AxObject;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;

import java.util.List;

@LargeTest
public class ActivityEspressoTest extends ActivityInstrumentationTestCase2<Activity> {

    private static final String COLLECTION = "col";
    private static final String APP_KEY_1 = "key";
    private Appstax ax;

    public ActivityEspressoTest() {
        super(Activity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
        ax = new Appstax(APP_KEY_1);
    }

    public void testInstance() {
        assertNotNull(ax);
    }

    public void testObject() {
        AxObject object = ax.object(COLLECTION);
        object.put("title", "hello");
        object.put("count", 42);
        assertEquals(COLLECTION, object.getCollection());
        assertEquals("hello", object.get("title"));
        assertEquals(42, object.get("count"));
    }

    public void testFile() {
        AxObject object = ax.object(COLLECTION);
        AxFile file = ax.file("123", "123".getBytes());
        object.put("file", file);
        assertNull(object.getId());
        assertNotNull(object.getFile("file").getName());
        assertNull(object.getFile("file").getUrl());
    }

    public void testChannel() {
        ax.channel("public/foo", new AxListener() {});
    }

    public void testSave() {
        ax.save(ax.object(COLLECTION), new Callback<AxObject>() {
            public void onSuccess(AxObject output) {
                assertTrue(false);
            }
            public void onError(Exception e) {
                assertNotNull(e);
            }
        });
    }

    public void testFind() {
        ax.find(COLLECTION, 123, new Callback<List<AxObject>>() {
            public void onSuccess(List<AxObject> output) {
                assertTrue(false);
            }
            public void onError(Exception e) {
                assertNotNull(e);
            }
        });
    }

    public void testRemove() {
        ax.remove(ax.object(COLLECTION), new Callback<AxObject>() {
            public void onSuccess(AxObject output) {
                assertTrue(false);
            }
            public void onError(Exception e) {
                assertNotNull(e);
            }
        });
    }

    public void testFilter() {
        ax.filter(COLLECTION, "Age > 42", new Callback<List<AxObject>>() {
            public void onSuccess(List<AxObject> output) {
                assertTrue(false);
            }
            public void onError(Exception e) {
                assertNotNull(e);
            }
        });
    }

}
