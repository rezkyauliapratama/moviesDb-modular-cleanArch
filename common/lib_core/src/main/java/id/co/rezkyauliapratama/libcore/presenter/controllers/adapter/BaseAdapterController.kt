package id.co.rezkyauliapratama.libcore.presenter.controllers.adapter

import id.co.rezkyauliapratama.libcore.presenter.controllers.BaseController
import id.co.rezkyauliapratama.libcore.presenter.views.ViewMvc

abstract class BaseAdapterController<VIEWMVC : ViewMvc> : BaseController<VIEWMVC>() {

    abstract fun bindViewAndRegistenerListener(viewMvc: VIEWMVC)

}
