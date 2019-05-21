package id.co.rezkyauliapratama.lib_presenter.domain.common

import id.co.rezkyauliapratama.lib_presenter.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_presenter.domain.executors.ThreadExecutor
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NetworkSchedulerTransformer<T> : SingleTransformer<T, T> {

    @Inject
    lateinit var threadExecutor: ThreadExecutor

    @Inject
    lateinit var postExecutionThread: PostExecutionThread

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
    }
}