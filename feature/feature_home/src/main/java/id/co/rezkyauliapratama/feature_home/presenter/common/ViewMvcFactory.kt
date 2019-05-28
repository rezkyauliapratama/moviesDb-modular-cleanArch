package id.co.rezkyauliapratama.feature_home.presenter.common

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.PopularMovieViewMvcImpl
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.PopularMovieAdapterViewMvcImpl
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.lib_presenter.presenter.common.BaseViewMvcFactory

class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) : BaseViewMvcFactory {

    fun getPopularMoviesViewMvc(parent: ViewGroup?): PopularMovieViewMvc{
        return PopularMovieViewMvcImpl(mLayoutInflater, parent)
    }

    fun getPopularMovieAdapterViewMvc(parent: ViewGroup?): PopularMovieAdapterViewMvc {
        return PopularMovieAdapterViewMvcImpl(mLayoutInflater, parent)
    }

}
