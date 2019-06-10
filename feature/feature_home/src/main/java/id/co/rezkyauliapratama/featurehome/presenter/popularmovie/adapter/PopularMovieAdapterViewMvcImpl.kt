package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.model.RowPopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.libcore.presenter.views.BaseObservableViewMvc
import id.co.rezkyauliapratama.libuicomponent.common.extension.loadImage
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
        view.setOnClickListener {
            for (listener in listeners){
                listener.onMovieItemClicked(position)
            }
        }
    }

}
