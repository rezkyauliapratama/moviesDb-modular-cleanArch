package id.co.rezkyauliapratama.lib_core.presenter.controllers

import id.co.rezkyauliapratama.lib_core.presenter.views.ViewMvc

abstract class BaseController<VIEWMVC : ViewMvc> {
    protected lateinit var mViewMvc: VIEWMVC
}