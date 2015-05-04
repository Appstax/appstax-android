package com.appstax.android;

import org.junit.*;

import static junit.framework.Assert.assertEquals;

public class AppstaxTest {

    private static final String APP_KEY_1 = "YourAppKey";
    private static final String APP_KEY_2 = "SomeAppKey";

    @Before
    public void before() {
        com.appstax.android.Appstax.setAppKey(APP_KEY_1);
    }

    @Test
    public void testAppKey() {
        assertEquals(APP_KEY_1, Appstax.getAppKey());
        Appstax.setAppKey(APP_KEY_2);
        assertEquals(APP_KEY_2, Appstax.getAppKey());
    }

}