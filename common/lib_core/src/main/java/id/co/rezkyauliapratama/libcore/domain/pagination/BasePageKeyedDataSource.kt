package id.co.rezkyauliapratama.libcore.domain.pagination

import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePageKeyedDataSource<KEY, VALUE> : PageKeyedDataSource<KEY, VALUE>() {

    abstract fun compositeDisposable() : CompositeDisposable


    protected fun Disposable.track() {
        compositeDisposable().add(this)
    }

}