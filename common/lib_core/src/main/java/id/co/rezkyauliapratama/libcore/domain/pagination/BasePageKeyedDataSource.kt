package id.co.rezkyauliapratama.libcore.domain.pagination

import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePageKeyedDataSource<KEY, VALUE>(private val compositeDisposable: CompositeDisposable) : PageKeyedDataSource<KEY, VALUE>() {

    protected fun Disposable.track() {
        compositeDisposable.add(this)
    }

}