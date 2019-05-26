package id.co.rezkyauliapratama.lib_presenter.domain.common

import id.co.rezkyauliapratama.lib_presenter.domain.executors.PostExecutionThread
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class SchedulerTransformer<T> : ObservableTransformer<T, T>, KoinComponent {

    val postExecutionThread: PostExecutionThread by inject()

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
    }
}