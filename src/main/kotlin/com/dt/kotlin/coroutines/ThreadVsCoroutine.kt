package com.dt.kotlin.coroutines

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/**
 * @author shashankmittal
 * @created 05/11/19
 */
private const val THREAD_COUNT = 1_000_000

fun main(args: Array<String>) {
//    simpleCoroutine()
    runThreads()
    runCoroutine()
}

fun simpleCoroutine() {
    println("Start")
    GlobalScope.launch {
        delay(1000)
        println("Hello")
    }
    Thread.sleep(2000)
    println("Stop")
}

//Expected Runtime : ~45 Seconds
private fun runThreads() {
    val measureTimeMillis = measureTimeMillis {
        val c = AtomicInteger()
        for (i in 1..THREAD_COUNT)
            thread(start = true) {
                c.addAndGet(i)
            }
        println(c.get())
    }
    println("Execution Time for $THREAD_COUNT threads is $measureTimeMillis millis")
}

//Expected Runtime : ~6 Seconds
private fun runCoroutine() {
    val measureTimeMillis = measureTimeMillis {
        val deferred = (1..THREAD_COUNT).map { n ->
            GlobalScope.async {
                task(n)
            }
        }
//        runBlocking (a suspend function) is required because await() can only be called from a coroutine or suspend function
        runBlocking {
            val result = deferred.sumBy { it.await() }
            println("Total for $THREAD_COUNT Threads is : $result")
        }
    }
    println("Execution Time for $THREAD_COUNT coroutine is $measureTimeMillis millis")
}

/*
delay (a suspend function) can be called from a coroutine or another suspend function.
Thus to make any function as suspend function, suspend keyword is used.
This can be considered as making a runnable task.
 */
suspend fun task(n: Int): Int {
    delay(1000)
    return n
}
