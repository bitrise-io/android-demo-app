package io.bitrise.sample.android.instrumentation

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.bitrise.sample.android", appContext.packageName)
    }

    @Test
    fun googleAPIAvailable() {
        val googleAPI: GoogleApiAvailability = GoogleApiAvailability.getInstance()
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val result: Int = googleAPI.isGooglePlayServicesAvailable(appContext)
        assertEquals(ConnectionResult.SUCCESS, result)
    }
}

