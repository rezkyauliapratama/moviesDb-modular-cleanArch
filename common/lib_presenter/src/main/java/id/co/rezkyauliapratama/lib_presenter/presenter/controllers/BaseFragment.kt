package id.co.rezkyauliapratama.lib_presenter.presenter.controllers

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.rezkyauliapratama.lib_presenter.presenter.views.ViewMvc
import androidx.fragment.app.Fragment
import id.co.rezkyauliapratama.lib_presenter.presenter.common.BaseViewMvcFactory
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.BaseViewModel


abstract class BaseFragment<VIEWMODEL:BaseViewModel, CONTROLLER : BaseController<VIEW_MVC,VIEWMODEL>, VIEW_MVC : ViewMvc>  : Fragment(){

    lateinit var viewMvcFactory: BaseViewMvcFactory

    lateinit var mController: CONTROLLER

    lateinit var mViewMvc: VIEW_MVC

    abstract fun inject()
    abstract fun initView(container: ViewGroup?)
    abstract fun initDataBinding()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity){
            inject()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        initView(container)
        initDataBinding()
        return mViewMvc.view
    }
}