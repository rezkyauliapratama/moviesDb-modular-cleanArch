package id.co.rezkyauliapratama.lib_core.presenter.controllers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.co.rezkyauliapratama.lib_core.presenter.common.BaseViewMvcFactory
import id.co.rezkyauliapratama.lib_core.presenter.views.ViewMvc
import javax.inject.Inject

abstract class BaseActivity<MVCFACTORY : BaseViewMvcFactory, CONTROLLER : BaseController<VIEWMVC>, VIEWMVC : ViewMvc> :
    AppCompatActivity() {

    @Inject
    lateinit var viewMvcFactory: BaseViewMvcFactory

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var mController: CONTROLLER

    lateinit var mViewMvc: VIEWMVC


    abstract fun inject()
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        initView()

        super.onCreate(savedInstanceState)
        setContentView(mViewMvc.view)
    }

}