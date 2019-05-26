package id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private var isFirst = true

    /**
     * Only can call once per lifecycle
     *
     * @param multipleTimes (OPTIONAL) set it to true to make multiple call capability
     */
    @CallSuper
    open fun loadPage(multipleTimes: Boolean? = false) {
        if (!isFirst && multipleTimes != true) {
            return
        }
        isFirst = false
    }

    private val compositeDisposable = CompositeDisposable()

    protected fun Disposable.track() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}