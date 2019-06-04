package id.co.rezkyauliapratama.lib_uicomponent.presenter.common

sealed class ResourceState {
    object LOADING : ResourceState()
    object SUCCESS : ResourceState()
    object ERROR : ResourceState()
}
