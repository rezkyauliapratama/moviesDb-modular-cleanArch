package id.co.rezkyauliapratama.lib_uicomponent.presenter.controllers

import id.co.rezkyauliapratama.lib_uicomponent.presenter.views.ViewMvc

abstract class BaseController<VIEWMVC: ViewMvc> {
    protected lateinit var mViewMvc: VIEWMVC
}