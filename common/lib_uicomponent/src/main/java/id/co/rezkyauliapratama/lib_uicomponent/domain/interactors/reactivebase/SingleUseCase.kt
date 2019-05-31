package id.co.rezkyauliapratama.lib_presenter.domain.interactors.reactivebase

import id.co.rezkyauliapratama.lib_presenter.domain.common.NetworkSchedulerTransformer
import io.reactivex.Single
import io.reactivex.SingleTransformer

abstract class SingleUseCase<RESULT>(private val errorTransformer: SingleTransformer<in RESULT,out RESULT>) {

    abstract fun buildUseCaseSingle(data: Map<String, Any?> = emptyMap()): Single<RESULT>

    fun execute(data: Map<String, Any?> = emptyMap()): Single<RESULT> {
        return buildUseCaseSingle(data)
            .compose(errorTransformer)
            .compose(NetworkSchedulerTransformer())
    }
}
