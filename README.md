# Appstax Android SDK

This is the official Android SDK for [Appstax](https://appstax.com).
Please read the [Android Guide](https://appstax.com/docs/Android-SDK-Guide) to get up and running.

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

