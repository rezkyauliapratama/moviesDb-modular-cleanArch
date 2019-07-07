package id.co.rezkyauliapratama.libcore.domain.interactors.reactivebase

import io.reactivex.Single
import io.reactivex.SingleTransformer

abstract class SingleUseCase<RESULT> constructor(
    private val networkSchedulerTransformer: SingleTransformer<in RESULT, out RESULT>
) {

    abstract fun buildUseCaseSingle(data: Map<String, Any?> = emptyMap()): Single<RESULT>

    fun execute(data: Map<String, Any?> = emptyMap()): Single<RESULT> {
        return buildUseCaseSingle(data)
            .compose(networkSchedulerTransformer)
    }
}
