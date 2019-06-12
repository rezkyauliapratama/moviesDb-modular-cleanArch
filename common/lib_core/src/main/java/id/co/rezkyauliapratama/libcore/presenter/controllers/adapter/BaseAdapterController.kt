package id.co.rezkyauliapratama.libcore.presenter.controllers.adapter

import id.co.rezkyauliapratama.libcore.presenter.controllers.BaseController
import id.co.rezkyauliapratama.libcore.presenter.views.ViewMvc

abstract class BaseAdapterController<VIEWMVC : ViewMvc, DATA> : BaseController<VIEWMVC>() {

    abstract fun bind(viewMvc: VIEWMVC, itemData: DATA?, position: Int)

}
