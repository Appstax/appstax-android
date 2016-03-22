# Appstax Android SDK

[![Build Status](https://travis-ci.org/Appstax/appstax-android.svg?branch=master)](https://travis-ci.org/Appstax/appstax-android)
[![Download](https://api.bintray.com/packages/appstax/maven/appstax-android/images/download.svg) ](https://bintray.com/appstax/maven/appstax-android/_latestVersion)

This is the official Android SDK for [AppStax](https://appstax.com).

It's a new SDK, so let us know if you encounter any issues.

Check out the [Android SDK Guide](https://appstax.com/docs/android-guide.html) to get started.

## Installation with Gradle

Add the SDK as a dependency in your app's `build.gradle` file:

```gradle
dependencies {
    compile 'com.appstax:appstax-android:+'
}
```

This assumes you're using the standard jcenter repository.

## Usage example

```java
Appstax ax = new Appstax("key");

AxObject object = ax.object("Contacts");
object.put("name", "Foo McBar");
object.put("email", "foo@example.com");

ax.save(object, new Callback<AxObject>() {
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

