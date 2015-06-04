# Release

Here's how you publish a new version of the Android SDK:

1. Check that the last [build is passing](https://travis-ci.org/Appstax/appstax-java) on Travis.
1. Check that you've set the env vars `BINTRAY_USER` and `BINTRAY_KEY`.
1. Check that `src/appstax-android/build.gradle:64` uses a published version of the Java SDK.
1. Set the new Android SDK version number in `src/appstax-android/build.gradle:5`.
1. Commit the new version number: `git commit -am "v1.2.3"`.
1. Push and publish the new version: `./scripts/release`.
