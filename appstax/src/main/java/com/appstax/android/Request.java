package com.appstax.android;

import com.appstax.AppstaxObject;

import java.util.List;

public class Request {

    public static Response<List<AppstaxObject>> find(String collection) {
        class Task extends Async<String,List<AppstaxObject>> {
            protected List<AppstaxObject> apply(String collection) {
                return AppstaxObject.find(collection);
            }
        }
        return new Task().perform(collection);
    }

    public static Response<AppstaxObject> save(AppstaxObject object) {
        class Task extends Async<AppstaxObject, AppstaxObject> {
            protected AppstaxObject apply(AppstaxObject object) {
                object.save();
                return object;
            }
        }
        return new Task().perform(object);
    }



}

