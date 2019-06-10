package id.co.rezkyauliapratama.feature_home.presenter.common

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.PopularMovieViewMvcImpl
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.PopularMovieAdapterViewMvcImpl
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.PopularMoviesAdapter
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.libcore.presenter.common.BaseViewMvcFactory

class ViewMvcFactory(
    private val mLayoutInflater: LayoutInflater
) : BaseViewMvcFactory {

    fun getPopularMoviesViewMvc(parent: ViewGroup?, popularMoviesAdapter: PopularMoviesAdapter): PopularMovieViewMvc {
        return PopularMovieViewMvcImpl(mLayoutInflater, parent, popularMoviesAdapter)
    }

    fun getPopularMovieAdapterViewMvc(parent: ViewGroup?): PopularMovieAdapterViewMvc {
        return PopularMovieAdapterViewMvcImpl(mLayoutInflater, parent)
    }

}
