package id.co.rezkyauliapratama.libcore.presenter.controllers

import id.co.rezkyauliapratama.libcore.presenter.views.ViewMvc

abstract class BaseController<VIEWMVC : ViewMvc> {
    protected lateinit var mViewMvc: VIEWMVC
}
