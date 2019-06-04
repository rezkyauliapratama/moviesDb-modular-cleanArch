package id.co.rezkyauliapratama.lib_uicomponent.presenter.common

data class Resource<out T> constructor(
    val state: ResourceState,
    val data: T? = null,
    val throwable: Throwable? = null
)
