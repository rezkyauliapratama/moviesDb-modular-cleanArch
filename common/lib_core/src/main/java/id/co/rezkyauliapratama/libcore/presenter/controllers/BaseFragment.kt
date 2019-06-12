package id.co.rezkyauliapratama.libcore.presenter.controllers

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.co.rezkyauliapratama.libcore.presenter.common.BaseViewMvcFactory
import id.co.rezkyauliapratama.libcore.presenter.views.ViewMvc
import javax.inject.Inject


abstract class BaseFragment<MVCFACTORY : BaseViewMvcFactory, CONTROLLER : BaseController<VIEWMVC>, VIEWMVC : ViewMvc> :
    Fragment() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var mViewMvcFactory: MVCFACTORY

    @Inject
    lateinit var mController: CONTROLLER

    lateinit var mViewMvc: VIEWMVC

    abstract fun injectDI()
    abstract fun initView(container: ViewGroup?)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            injectDI()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initView(container)
        return mViewMvc.view
    }

}
