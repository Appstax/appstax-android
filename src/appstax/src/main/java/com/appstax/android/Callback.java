package com.appstax.android;

public abstract class Callback<O> {
    public void onSuccess(O output) {};
    public void onError(Exception e) {};
}
