package com.appstax.android;

public class Response<T> {

    private T result;
    private Exception error;

    public Response() {
        super();
    }

    public Response(T result) {
        super();
        this.result = result;
    }

    public Response(Exception error) {
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
