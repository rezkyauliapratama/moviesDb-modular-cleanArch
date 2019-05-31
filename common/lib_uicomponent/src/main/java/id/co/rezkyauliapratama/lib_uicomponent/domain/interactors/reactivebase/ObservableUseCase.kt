package id.co.rezkyauliapratama.lib_uicomponent.domain.interactors.reactivebase

import id.co.rezkyauliapratama.lib_uicomponent.domain.common.SchedulerTransformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer


abstract class ObservableUseCase<RESULT>(private val errorTransformer: ObservableTransformer<in RESULT,out RESULT>) {

    abstract fun buildUseCaseSingle(data: Map<String, Any?> = emptyMap()): Observable<RESULT>

    fun execute(data: Map<String, Any?> = emptyMap()): Observable<RESULT> {
        return buildUseCaseSingle(data)
            .compose(errorTransformer)
            .compose(SchedulerTransformer())
    }
}
