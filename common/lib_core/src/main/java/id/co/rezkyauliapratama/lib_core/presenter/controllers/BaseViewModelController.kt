package id.co.rezkyauliapratama.lib_core.presenter.controllers

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import id.co.rezkyauliapratama.lib_core.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_core.presenter.views.ViewMvc

abstract class BaseViewModelController<VIEWMVC : ViewMvc, VIEWMODEL : BaseViewModel> : BaseController<VIEWMVC>() {

    protected lateinit var mViewModel: VIEWMODEL
    protected lateinit var mLifecycle: LifecycleOwner

    abstract fun bind(viewMvc: VIEWMVC, viewModel: VIEWMODEL, lifecycle: LifecycleOwner)

    @CallSuper
    protected open fun initLiveDataObservers() {
    }

    @CallSuper
    open fun onCreated() {
        initLiveDataObservers()
        mViewModel.loadPage()
    }

    @CallSuper
    open fun onStart() {

    }

    @CallSuper
    open fun onStop() {

    }

    @CallSuper
    open fun onDestroyed() {

    }
}