package com.example.activity;

import com.appstax.android.Appstax;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class ExampleActivityTest {

    private static final String APP_KEY_1 = "YourAppKey";
    private static final String APP_KEY_2 = "SomeAppKey";
    private static final String API_URL_1 = "https://appstax.com/api/latest/";

    @Before
    public void before() {
        Appstax.setAppKey(APP_KEY_1);
    }

    @Test
    public void testRoboelectricSetup() throws Exception {
        assertTrue(Robolectric.buildActivity(ExampleActivity.class).create().get() != null);
    }

    @Test
    public void testAppKey() {
        assertEquals(APP_KEY_1, Appstax.getAppKey());
        Appstax.setAppKey(APP_KEY_2);
        assertEquals(APP_KEY_2, Appstax.getAppKey());
    }

    @Test
    public void testApiUrl() {
        assertEquals(API_URL_1, Appstax.getApiUrl());
    }

}
