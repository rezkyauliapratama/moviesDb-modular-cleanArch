package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.lib_presenter.R
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view.LoaderAdapterViewMvc
import id.co.rezkyauliapratama.libcore.presenter.views.BaseViewMvc

class LoaderAdapterViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) : BaseViewMvc(), LoaderAdapterViewMvc {

    init {
        view = inflater.inflate(R.layout.widget_progressbar, parent, false)
    }

}