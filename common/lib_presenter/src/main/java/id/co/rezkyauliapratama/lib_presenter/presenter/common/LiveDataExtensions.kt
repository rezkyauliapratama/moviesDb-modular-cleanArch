package id.co.rezkyauliapratama.lib_presenter.presenter.common

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T) =
    postValue(
        Resource(
            ResourceState.SUCCESS,
            data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(
        Resource(
            ResourceState.LOADING,
            value?.data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setError(throwable: Throwable? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            throwable
        )
    )
