package id.co.rezkyauliapratama.lib_presenter.domain.common

import id.co.rezkyauliapratama.lib_presenter.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_presenter.domain.executors.ThreadExecutor
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class NetworkSchedulerTransformer<T> : SingleTransformer<T, T>, KoinComponent {

    private val threadExecutor: ThreadExecutor by inject()

    private val postExecutionThread: PostExecutionThread by inject()

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
    }
}