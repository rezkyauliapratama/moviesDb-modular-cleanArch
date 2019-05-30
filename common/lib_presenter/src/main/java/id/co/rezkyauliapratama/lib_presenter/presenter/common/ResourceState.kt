package id.co.rezkyauliapratama.lib_presenter.presenter.common

sealed class ResourceState {
    object LOADING : ResourceState()
    object SUCCESS : ResourceState()
    object ERROR : ResourceState()
}
