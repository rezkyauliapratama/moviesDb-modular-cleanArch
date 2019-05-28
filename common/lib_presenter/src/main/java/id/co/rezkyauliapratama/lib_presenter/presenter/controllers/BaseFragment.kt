package id.co.rezkyauliapratama.lib_presenter.presenter.controllers

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.co.rezkyauliapratama.lib_presenter.presenter.common.BaseViewMvcFactory
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_presenter.presenter.views.ViewMvc


abstract class BaseFragment<MVCFACTORY: BaseViewMvcFactory, VIEWMODEL : BaseViewModel, CONTROLLER : BaseController<VIEWMVC, VIEWMODEL>, VIEWMVC : ViewMvc> :
    Fragment() {

    lateinit var mViewMvcFactory: MVCFACTORY

    lateinit var mController: CONTROLLER

    lateinit var mViewMvc: VIEWMVC

    abstract fun inject()
    abstract fun initView(container: ViewGroup?)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            inject()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        initView(container)
        return mViewMvc.view
    }
}