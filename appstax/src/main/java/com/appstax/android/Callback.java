package com.appstax.android;

public abstract class Callback<O> {
    public void done(O output) {};
    public void fail(Exception e) {};
}
