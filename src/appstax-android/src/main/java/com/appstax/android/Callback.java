package com.appstax.android;

import com.appstax.AxException;

public abstract class Callback<O> {
    public void onSuccess(O output) {};
    public void onError(AxException e) {};
}
