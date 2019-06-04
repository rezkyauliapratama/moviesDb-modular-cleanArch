package id.co.rezkyauliapratama.lib_core.presenter

import id.co.rezkyauliapratama.lib_core.domain.executors.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
