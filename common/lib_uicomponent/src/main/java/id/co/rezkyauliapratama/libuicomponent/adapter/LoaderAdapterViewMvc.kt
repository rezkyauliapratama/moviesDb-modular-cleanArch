package id.co.rezkyauliapratama.libuicomponent.adapter

import id.co.rezkyauliapratama.libcore.presenter.views.ViewMvc


interface LoaderAdapterViewMvc : ViewMvc {

    fun displayProgressBar()

    fun displayMessage(message: String? = null)

}