package io.bitrise.sample.android

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_isIncorrect() {
        assertEquals(4, 2 + 3)
    }

    @Test
    fun addition_anotherFailingTest() {
        assertEquals(4, 2 + 3)
    }
}