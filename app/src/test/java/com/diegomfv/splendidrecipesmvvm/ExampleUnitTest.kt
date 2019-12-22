package com.diegomfv.splendidrecipesmvvm

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

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
    fun performanceTest () {
        runBlocking {

            var t = measureTimeMillis {
                for (i in 0 until 100000000) {
                    callingFunctionInlined()
                }
            }
            println(t)

            t = measureTimeMillis {
                for (i in 0 until 100000000) {
                    callingFunctionNotInlined()
                }
            }
            println(t)
        }
    }

    fun callingFunctionNotInlined() {
        notUsingInlineCallingLambda { var a = 0 }
    }

    fun callingFunctionInlined() {
        usingInlineCallingLambda { var a = 0 }
    }

    fun notUsingInlineCallingLambda (lambda: () -> Unit) {
        lambda.invoke()
    }

    inline fun usingInlineCallingLambda (lambda: () -> Unit) {
        lambda.invoke()
    }
}
