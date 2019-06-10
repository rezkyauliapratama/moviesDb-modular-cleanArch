package id.co.rezkyauliapratama.libcore.presenter.common

sealed class ResourceState {
    object LOADING : ResourceState()
    object SUCCESS : ResourceState()
    object ERROR : ResourceState()
}
