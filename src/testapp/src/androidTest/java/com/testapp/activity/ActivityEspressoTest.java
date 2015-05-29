package com.testapp.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.appstax.AxException;
import com.appstax.AxObject;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class ActivityEspressoTest extends ActivityInstrumentationTestCase2<Activity> {

    private static final String APP_KEY_1 = "YourApiKey";
    private static final String APP_KEY_2 = "SomeAppKey";
    private static final String API_URL_1 = com.appstax.Ax.getApiUrl();

    private static final String COLLECTION_COUNT = "CountCollection";
    private static final String COLLECTION_BLANK = "BlankCollection";

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

    public void testActivityShouldHaveText() throws InterruptedException {
        onView(withText(COLLECTION_BLANK)).check(matches(isDisplayed()));
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
        AxObject object = new AxObject(COLLECTION_COUNT);
        object.put("title", "hello");
        object.put("count", 42);
        assertEquals(COLLECTION_COUNT, object.getCollection());
        assertEquals("hello", object.get("title"));
        assertEquals(42, object.get("count"));
    }

    public void testObjectSave() {
        Appstax.save(new AxObject(COLLECTION_BLANK), new Callback<AxObject>() {
            public void onSuccess(AxObject output) {
                assertTrue(false);
            }
            public void onError(AxException e) {
                assertTrue(e.getMessage().startsWith("Not authorized."));
            }
        });
    }

    public void testObjectRemove() {
        Appstax.remove(new AxObject(COLLECTION_BLANK), new Callback<AxObject>() {
            public void onSuccess(AxObject output) {
                assertTrue(false);
            }
            public void onError(AxException e) {
                assertTrue(e.getMessage().startsWith("Not authorized."));
            }
        });
    }

    public void testObjectFilter() {
        Appstax.filter(COLLECTION_BLANK, "Age > 42", new Callback<List<AxObject>>() {
            public void onSuccess(List<AxObject> output) {
                assertTrue(false);
            }
            public void onError(AxException e) {
                assertTrue(e.getMessage().startsWith("Not authorized."));
            }
        });
    }

}
