package com.appstax.android;

public abstract class Appstax {

    public static void setAppKey(final String key) {
        com.appstax.Appstax.setAppKey(key);
    }

    public static String getAppKey() {
        return com.appstax.Appstax.getAppKey();
    }

}
