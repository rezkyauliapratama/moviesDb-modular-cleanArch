package id.co.rezkyauliapratama.lib_presenter.presenter

import id.co.rezkyauliapratama.lib_presenter.domain.executors.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
