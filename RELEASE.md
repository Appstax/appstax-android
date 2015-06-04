# Release

Here's how you publish a new version of the Android SDK:

0. Make sure you've set the env vars `BINTRAY_USER` and `BINTRAY_KEY`.
1. Check that `src/appstax-android/build.gradle:64` uses a published version of the Java SDK.
2. Set the new Android SDK version number in `src/appstax-android/build.gradle:5`.
3. Commit the new version number: `git commit -am "v1.2.3"`.
4. Push and publish the new version: `./scripts/release`.
