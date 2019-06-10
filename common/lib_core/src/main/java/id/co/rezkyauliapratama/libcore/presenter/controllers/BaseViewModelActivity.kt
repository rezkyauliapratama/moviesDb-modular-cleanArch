package id.co.rezkyauliapratama.lib_core.presenter.controllers

import android.os.Bundle
import androidx.annotation.CallSuper
import id.co.rezkyauliapratama.lib_core.presenter.common.BaseViewMvcFactory
import id.co.rezkyauliapratama.lib_core.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_core.presenter.views.ViewMvc

abstract class BaseViewModelActivity<MVCFACTORY : BaseViewMvcFactory, VIEWMODEL : BaseViewModel, CONTROLLER : BaseViewModelController<VIEWMVC, VIEWMODEL>, VIEWMVC : ViewMvc>
    : BaseActivity<MVCFACTORY, CONTROLLER, VIEWMVC>() {

    protected val viewModel by lazy { buildViewModel() }

    protected abstract fun buildViewModel(): VIEWMODEL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mController.onCreated()
        initLiveDataObservers()
        viewModel.loadPage()
    }


    @CallSuper
    protected open fun initLiveDataObservers() {
    }

    override fun onStart() {
        super.onStart()
        mController.onStart()
    }

    override fun onStop() {
        super.onStop()
        mController.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mController.onDestroyed()
    }


}
