# Appstax Android SDK

[![Build Status](https://travis-ci.org/Appstax/appstax-android.svg?branch=master)](https://travis-ci.org/Appstax/appstax-android)

This is the official Android SDK for [Appstax](https://appstax.com).

It's a work in progress, and not ready for use quite yet.

## Example

```java
Appstax.setAppKey("YourAppKey");

AxObject object = new AxObject("Contacts");
object.put("name", "Foo McBar");
object.put("email", "foo@example.com");

Appstax.save(object, new Callback<AxObject>() {
    public void onSuccess(AxObject object) {
        showMessage("saved", object.get("name"));
    }
    public void onError(AxException e) {
        showMessage("error", e.getMessage());
    });
});
```

## License

[MIT License](LICENSE)

