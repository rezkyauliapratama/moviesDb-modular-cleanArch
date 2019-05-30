package id.co.rezkyauliapratama.lib_presenter.presenter.controllers

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_presenter.presenter.views.ViewMvc

abstract class BaseController<VIEWMVC : ViewMvc, VIEWMODEL : BaseViewModel> {

    protected lateinit var mViewMvc: VIEWMVC
    protected lateinit var mViewModel: VIEWMODEL
    protected lateinit var mLifecycle: LifecycleOwner

    abstract fun bind(viewMvc: VIEWMVC, viewModel: VIEWMODEL, lifecycle: LifecycleOwner)
    abstract fun initLiveDataObservers()

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