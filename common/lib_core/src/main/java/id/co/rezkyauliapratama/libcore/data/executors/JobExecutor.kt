package id.co.rezkyauliapratama.libcore.data.executors

import android.os.Process
import android.util.Log
import id.co.rezkyauliapratama.libcore.domain.executors.ThreadExecutor
import timber.log.Timber
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

open class JobExecutor : ThreadExecutor {

    private val numberOfCores = Runtime.getRuntime().availableProcessors()

    // Sets the amount of time an idle thread waits before terminating
    private val keepAliveTimes = 1

    // Sets the Time Unit to seconds
    private val keepAliveTimeUnit = TimeUnit.SECONDS

    private val workQueue: LinkedBlockingQueue<Runnable> = LinkedBlockingQueue()

    private val threadPoolExecutor: ThreadPoolExecutor

    private val threadFactory: ThreadFactory

    init {
        this.threadFactory = id.co.rezkyauliapratama.libcore.data.executors.JobExecutor.JobThreadFactory()
        this.threadPoolExecutor = ThreadPoolExecutor(
            numberOfCores,
            numberOfCores * 2,
            keepAliveTimes.toLong(),
            keepAliveTimeUnit, this.workQueue, this.threadFactory
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
                "$THREAD_NAME${counter++}"
            thread.priority = Process.THREAD_PRIORITY_BACKGROUND

            // A exception handler is created to log the exception from threads
            thread.uncaughtExceptionHandler =
                Thread.UncaughtExceptionHandler { th, ex ->
                    Timber.e(
                        "%s%s", "${th.name} encountered an error: ", ex.message
                    )
                }
            return thread
        }

        companion object {
            private val THREAD_NAME = "network_"
        }
    }

}
