package id.co.rezkyauliapratama.lib_presenter.presenter.controllers

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_presenter.presenter.views.ViewMvc

abstract class BaseController<VIEWMVC : ViewMvc, VIEWMODEL : BaseViewModel> : LifecycleObserver {

    protected lateinit var mViewMvc: VIEWMVC
    protected lateinit var mViewModel: VIEWMODEL
    protected lateinit var mLifecycle: Lifecycle

    abstract fun bindController(viewMvc: VIEWMVC, viewModel: VIEWMODEL, lifecycle: Lifecycle)


    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun registerListener() {
        if(!::mLifecycle.isInitialized){
            return
        }
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun unRegisterListener() {

    }
}