package io.bitrise.sample.android.ui

import android.os.Environment.DIRECTORY_PICTURES
import android.os.Environment.getExternalStoragePublicDirectory
import android.util.Log
import androidx.test.runner.screenshot.BasicScreenCaptureProcessor
import androidx.test.runner.screenshot.Screenshot
import io.bitrise.sample.android.BuildConfig
import java.io.File
import java.io.IOException

private const val TAG = "ScreenshotsUtils"

fun takeScreenshot(screenShotName: String) {
    Log.d(TAG, "Taking screenshot of '$screenShotName'")
    val screenCapture = Screenshot.capture()
    val processors = setOf(MyScreenCaptureProcessor())
    try {
        screenCapture.apply {
            name = screenShotName
            process(processors)
        }
        Log.d(TAG, "Screenshot taken")
    } catch (ex: IOException) {
        Log.e(TAG, "Could not take a screenshot", ex)
    }
}


class MyScreenCaptureProcessor : BasicScreenCaptureProcessor() {
    init {
        this.mDefaultScreenshotPath = File(
            File(
                getExternalStoragePublicDirectory(DIRECTORY_PICTURES),
                ""
            ).absolutePath,
            SCREENSHOTS_FOLDER_NAME
        )
    }

    override fun getFilename(prefix: String): String = prefix

    companion object {
        const val SCREENSHOTS_FOLDER_NAME = "screenshots"
    }
}