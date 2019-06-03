package id.co.rezkyauliapratama.lib_uicomponent.domain.interactors.reactivebase

import id.co.rezkyauliapratama.lib_uicomponent.domain.common.NetworkSchedulerTransformer
import io.reactivex.Single
import io.reactivex.SingleTransformer
import javax.inject.Inject

abstract class SingleUseCase<RESULT> constructor(
    private val networkSchedulerTransformer: SingleTransformer<in RESULT, out RESULT>,
    private val errorApiTransformer: SingleTransformer<in RESULT, out RESULT>
) {

    abstract fun buildUseCaseSingle(data: Map<String, Any?> = emptyMap()): Single<RESULT>

    fun execute(data: Map<String, Any?> = emptyMap()): Single<RESULT> {
        return buildUseCaseSingle(data)
            .compose(errorApiTransformer)
            .compose(networkSchedulerTransformer)
    }
}
