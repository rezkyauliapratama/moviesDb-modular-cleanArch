package id.co.rezkyauliapratama.lib_presenter.presenter.controllers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.co.rezkyauliapratama.lib_presenter.presenter.common.BaseViewMvcFactory
import id.co.rezkyauliapratama.lib_presenter.presenter.views.ViewMvc
import javax.inject.Inject

abstract class BaseActivity<CONTROLLER : BaseController, VIEW_MVC : ViewMvc> : AppCompatActivity() {

    @Inject
    lateinit var viewMvcFactory: BaseViewMvcFactory

    @Inject
    lateinit var mController: CONTROLLER

    lateinit var mViewMvc: VIEW_MVC


    abstract fun inject()
    abstract fun initView()


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        initView()

        super.onCreate(savedInstanceState)

        setContentView(mViewMvc.layoutRes)
    }


}