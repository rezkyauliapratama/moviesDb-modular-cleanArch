package id.co.rezkyauliapratama.lib_core.domain.common

import id.co.rezkyauliapratama.lib_core.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_core.domain.executors.ThreadExecutor
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NetworkSchedulerTransformer<T> @Inject constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread): SingleTransformer<T, T> {

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
    }
}