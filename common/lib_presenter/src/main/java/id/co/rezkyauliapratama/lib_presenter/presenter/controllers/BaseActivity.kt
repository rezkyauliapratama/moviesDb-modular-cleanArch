package id.co.rezkyauliapratama.lib_presenter.presenter.controllers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.co.rezkyauliapratama.lib_presenter.presenter.common.BaseViewMvcFactory
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_presenter.presenter.views.ViewMvc
import org.koin.core.KoinComponent

abstract class BaseActivity<VIEWMODEL:BaseViewModel, CONTROLLER : BaseController<VIEW_MVC,VIEWMODEL>, VIEW_MVC : ViewMvc> : AppCompatActivity(), KoinComponent {

    lateinit var viewMvcFactory: BaseViewMvcFactory

    lateinit var mController: CONTROLLER

    lateinit var mViewMvc: VIEW_MVC


    abstract fun inject()
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        initView()

        super.onCreate(savedInstanceState)
        mController.onCreated()
        setContentView(mViewMvc.view)
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