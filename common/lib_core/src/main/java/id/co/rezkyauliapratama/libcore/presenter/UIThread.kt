package id.co.rezkyauliapratama.libcore.presenter

import id.co.rezkyauliapratama.libcore.domain.executors.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
