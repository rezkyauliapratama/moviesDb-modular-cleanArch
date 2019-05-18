package id.co.rezkyauliapratama.lib_presenter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel<STATE : state> : ViewModel() {

    internal val stateLiveData =
        SingleLiveEvent<STATE>()

    private val compositeDisposable = CompositeDisposable()

    fun getState(): LiveData<STATE> = stateLiveData

    protected fun Disposable.track() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}