package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.model.RowPopularMovieResult
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.lib_core.presenter.views.BaseObservableViewMvc
import id.co.rezkyauliapratama.lib_uicomponent.common.extension.loadImage
import kotlinx.android.synthetic.main.list_item_movie.view.*
import timber.log.Timber


class PopularMovieAdapterViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<PopularMovieAdapterViewMvc.Listener>(), PopularMovieAdapterViewMvc {


    init {
        view = inflater.inflate(R.layout.list_item_movie, parent, false)
    }

    override fun bindMovies(popularMoveResult: RowPopularMovieResult, position: Int) {
        Timber.e("popularMoveResult $popularMoveResult")
        view.tvTitle.text = popularMoveResult.getOriginalTitle()
        view.tvScore.text = popularMoveResult.getVoteAverage()
        view.ivPoster.loadImage(popularMoveResult.getThumnailImage())
    }

}