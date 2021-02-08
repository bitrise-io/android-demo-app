# Bitrise Android Sample

[![Bitrise status](https://app.bitrise.io/app/126b7fcfb72b97b4/status.svg?token=h4grjIEASivj7z_plB9zGg&branch=main)](https://app.bitrise.io/app/126b7fcfb72b97b4)

This is a sample Android project that demonstrates a typical [Bitrise](https://bitrise.io) CI/CD setup. Build history is publicly available [here](https://app.bitrise.io/app/126b7fcfb72b97b4#/builds).

## Project setup and config

### Bitrise workflow

There are two Bitrise workflows configured: `primary` and `deploy`. `primary` is triggered by any commit on any branch, while `deploy` can be started manually. The `primary` workflow builds and tests only the debug variant, meanwhile `deploy` builds a release app and signs it with the release signing config.

#### `primary` workflow

<details>
<summary>Workflow steps</summary>

![Primary workflow](docs/workflow-primary.png)
</details>

This workflow is automatically run by Bitrise on every commit on every branch. This builds and tests only the debug variant for faster results. In addition to running lint and unit tests, the [Virtual Device Testing](https://www.bitrise.io/integrations/steps/virtual-device-testing-for-android) step runs UI tests on a virtual device.

#### `deploy` workflow

#### Release builds

- R8 obfuscation and minification enabled in `build.gradle`
- No signing config in Gradle, builds are signed by the Sign step on Bitrise
- Signing keystore and passwords are stored securely on Bitrise
- Auto-incrementing `versionCode` based on the [Bitrise build number](https://devcenter.bitrise.io/builds/build-numbering-and-app-versioning/)

### Testing

#### UI tests

UI tests are run on emulators with the [Virtual Device Testing](https://www.bitrise.io/integrations/steps/virtual-device-testing-for-android) step.

## Advanced use cases

While this repo demonstrates a simple project config on Bitrise, there are many advanced features that might be relevant for your project:

- [Generating multiple APKs (multi-flavor) in one workflow](https://devcenter.bitrise.io/deploy/android-deploy/generate-and-deploy-multiple-flavor-apks-in-a-single-workflow/)
- [Exporting a universal APK from an AAB](https://devcenter.bitrise.io/deploy/android-deploy/exporting-a-universal-apk-from-an-aab/)
- [Running tests in Visual Studio App Center](https://devcenter.bitrise.io/testing/run-your-tests-in-the-app-center/)
- [Measuring your code coverage with Codecov](https://devcenter.bitrise.io/testing/measuring-your-code-coverage-with-codecov/)