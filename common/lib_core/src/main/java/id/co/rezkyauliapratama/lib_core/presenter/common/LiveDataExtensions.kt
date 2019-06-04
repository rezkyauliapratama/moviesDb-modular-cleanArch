package id.co.rezkyauliapratama.lib_uicomponent.presenter.common

import androidx.lifecycle.MediatorLiveData
import id.co.rezkyauliapratama.lib_uicomponent.presenter.viewmodels.SingleLiveEvent

fun <T> SingleLiveEvent<Resource<T>>.setSuccess(data: T): SingleLiveEvent<Resource<T>> {
    postValue(
        Resource(
            ResourceState.SUCCESS,
            data
        )
    )
    return this
}

fun <T> SingleLiveEvent<Resource<T>>.setLoading() =
    postValue(
        Resource(
            ResourceState.LOADING,
            value?.data
        )
    )

fun <T> SingleLiveEvent<Resource<T>>.setEmpty() =
    postValue(
        Resource(
            ResourceState.SUCCESS,
            null
        )
    )

fun <T> SingleLiveEvent<Resource<T>>.setError(throwable: Throwable? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            throwable
        )
    )
