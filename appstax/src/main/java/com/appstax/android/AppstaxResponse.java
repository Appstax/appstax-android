package com.appstax.android;

public class AppstaxResponse<T> {

    private T result;
    private Exception error;

    public AppstaxResponse() {
        super();
    }

    public AppstaxResponse(T result) {
        super();
        this.result = result;
    }

    public AppstaxResponse(Exception error) {
        super();
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

}
