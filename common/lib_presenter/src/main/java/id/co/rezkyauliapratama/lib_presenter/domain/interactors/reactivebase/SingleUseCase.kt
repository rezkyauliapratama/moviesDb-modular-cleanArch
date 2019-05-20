package id.co.rezkyauliapratama.lib_presenter.domain.interactors.reactivebase

import id.co.rezkyauliapratama.lib_presenter.domain.common.SchedulerTransformer
import io.reactivex.Single

abstract class SingleUseCase<RESULT> {

    abstract fun buildUseCaseSingle(data: Map<String, Any?> = emptyMap()): Single<RESULT>

    fun execute(data: Map<String, Any?> = emptyMap()): Single<RESULT> {
        return buildUseCaseSingle(data)
            .compose(SchedulerTransformer())
    }
}
