# Appstax Android SDK

This is the official SDK for [Appstax](https://appstax.com).
Please read the [Android Guide](https://appstax.com/docs/Android-SDK-Guide) to get up and running.

## Installing

The easiest way to get started, is to try out the Android Studio project in `examples/basic`.

Here's how you can add the SDK to your Android Studio project:

* [Download the latest release](https://github.com/appstax/appstax-java/releases).
* Add the downloaded JAR to the `app/libs` folder.
* Add the dependency to your `app/build.gradle`:

```gradle
dependencies {
    // ...
    compile files('libs/appstax-android.jar')
}
```

* Permit internet access in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

* Set your app key:

```java
Appstax.setAppKey("YourAppKey");
```

## Example usage

```java
Appstax.setAppKey("YourAppKey");

AxObject object = new AxObject("Contacts");
object.put("name", "Foo McBar");
object.put("email", "foo@example.com");

Appstax.save(object, new Callback<AxObject>() {
    public void onSuccess(AxObject object) {
        showMessage("saved", object.get("name"));
    }
    public void onError(Exception e) {
        showMessage("error", e.getMessage());
    });
});
```

See the [Android Guide](https://appstax.com/docs/Android-SDK-Guide) for more info on how to set up your app and data model.


License
-------

[MIT License](LICENSE)

