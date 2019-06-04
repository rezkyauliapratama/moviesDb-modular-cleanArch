package id.co.rezkyauliapratama.lib_core.data.executors

import android.os.Process
import android.util.Log
import id.co.rezkyauliapratama.lib_core.domain.executors.ThreadExecutor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

open class JobExecutor : ThreadExecutor {

    private val NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors()

    // Sets the amount of time an idle thread waits before terminating
    private val KEEP_ALIVE_TIME = 1

    // Sets the Time Unit to seconds
    private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS

    private val workQueue: LinkedBlockingQueue<Runnable> = LinkedBlockingQueue()

    private val threadPoolExecutor: ThreadPoolExecutor

    private val threadFactory: ThreadFactory

    init {
        this.threadFactory = id.co.rezkyauliapratama.lib_core.data.executors.JobExecutor.JobThreadFactory()
        this.threadPoolExecutor = ThreadPoolExecutor(
            NUMBER_OF_CORES,
            NUMBER_OF_CORES * 2,
            KEEP_ALIVE_TIME.toLong(),
            KEEP_ALIVE_TIME_UNIT, this.workQueue, this.threadFactory
        )
    }

    override fun execute(runnable: Runnable?) {
        if (runnable == null) {
            throw IllegalArgumentException("Runnable to execute cannot be null")
        }
        this.threadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            val thread = Thread(runnable)
            thread.name =
                "${id.co.rezkyauliapratama.lib_core.data.executors.JobExecutor.JobThreadFactory.Companion.THREAD_NAME}${counter++}"
            thread.priority = Process.THREAD_PRIORITY_BACKGROUND

            // A exception handler is created to log the exception from threads
            thread.uncaughtExceptionHandler =
                Thread.UncaughtExceptionHandler { th, ex ->
                    Log.e(
                        "JobExecutor",
                        th.name + " encountered an error: " + ex.message
                    )
                }
            return thread
        }

        companion object {
            private val THREAD_NAME = "network_"
        }
    }


}