package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.BuildConfig
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.lib_uicomponent.common.extension.loadImage
import id.co.rezkyauliapratama.lib_uicomponent.presenter.views.BaseObservableViewMvc
import kotlinx.android.synthetic.main.list_item_movie.view.*


class PopularMovieAdapterViewMvcImpl (inflater: LayoutInflater, parent: ViewGroup?) :
        BaseObservableViewMvc<PopularMovieAdapterViewMvc.Listener>(), PopularMovieAdapterViewMvc {


    init {
        view = inflater.inflate(R.layout.list_item_movie, parent, false)
    }

    override fun bindMovies(popularMoveView: PopularMovieView, position: Int) {
        view.tvTitle.text = popularMoveView.originalTitle
        view.tvScore.text = popularMoveView.popularity.toString()

        view.ivPoster.loadImage("${BuildConfig.IMAGE_BASE_URL}${popularMoveView.backdropPath}")
    }

}