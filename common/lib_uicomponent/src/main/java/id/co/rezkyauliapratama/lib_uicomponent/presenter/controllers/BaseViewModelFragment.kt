package id.co.rezkyauliapratama.lib_uicomponent.presenter.controllers

import android.os.Bundle
import androidx.annotation.CallSuper
import id.co.rezkyauliapratama.lib_uicomponent.presenter.common.BaseViewMvcFactory
import id.co.rezkyauliapratama.lib_uicomponent.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_uicomponent.presenter.views.ViewMvc


abstract class BaseViewModelFragment<MVCFACTORY: BaseViewMvcFactory, VIEWMODEL : BaseViewModel, CONTROLLER : BaseController<VIEWMVC, VIEWMODEL>, VIEWMVC : ViewMvc>
    : BaseFragment<MVCFACTORY, VIEWMODEL, CONTROLLER, VIEWMVC>() {

    protected val viewModel by lazy { buildViewModel() }

    protected abstract fun buildViewModel(): VIEWMODEL

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initLiveDataObservers()
    }

    @CallSuper
    protected open fun initLiveDataObservers() {
    }

}
