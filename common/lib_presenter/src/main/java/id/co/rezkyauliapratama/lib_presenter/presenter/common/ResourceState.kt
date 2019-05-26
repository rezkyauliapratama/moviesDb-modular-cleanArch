package id.co.rezkyauliapratama.lib_presenter.presenter.common

sealed class ResourceState {
    object LOADING : ResourceState()
    object SUCCESS : ResourceState()
    object EMPTY : ResourceState()
    object ERROR : ResourceState()
}
