package id.co.rezkyauliapratama.feature_home.presenter.common

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.PopularMovieAdapterViewMvcImpl
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc

class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) {

    fun getPopularMovieAdapterViewMvc(parent: ViewGroup?): PopularMovieAdapterViewMvc {
        return PopularMovieAdapterViewMvcImpl(mLayoutInflater, parent)
    }

}
