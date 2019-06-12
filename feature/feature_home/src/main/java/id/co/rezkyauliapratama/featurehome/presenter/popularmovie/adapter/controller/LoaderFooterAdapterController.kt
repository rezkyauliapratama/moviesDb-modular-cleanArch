package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller

import id.co.rezkyauliapratama.libuicomponent.adapter.LoaderAdapterViewMvc
import id.co.rezkyauliapratama.libcore.presenter.common.ResourceState
import id.co.rezkyauliapratama.libcore.presenter.controllers.adapter.BaseAdapterController

class LoaderFooterAdapterController : BaseAdapterController<id.co.rezkyauliapratama.libuicomponent.adapter.LoaderAdapterViewMvc, ResourceState>() {

    override fun bind(viewMvc: id.co.rezkyauliapratama.libuicomponent.adapter.LoaderAdapterViewMvc, itemData: ResourceState?, position: Int) {
        mViewMvc = viewMvc

        if (itemData == ResourceState.LOADING) {
            mViewMvc.displayProgressBar()
        } else {
            mViewMvc.displayMessage()
        }
    }

}