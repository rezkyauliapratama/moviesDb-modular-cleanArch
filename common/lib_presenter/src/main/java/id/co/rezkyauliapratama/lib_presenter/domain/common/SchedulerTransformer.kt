package id.co.rezkyauliapratama.lib_presenter.domain.common

import id.co.rezkyauliapratama.lib_presenter.domain.executors.PostExecutionThread
import io.reactivex.*
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulerTransformer<T> : ObservableTransformer<T, T> {

    @Inject
    lateinit var postExecutionThread: PostExecutionThread

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
    }
}