package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.libcore.presenter.views.BaseObservableViewMvc
import kotlinx.android.synthetic.main.list_item_movie.view.*


class PopularMovieAdapterViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<PopularMovieAdapterViewMvc.Listener>(), PopularMovieAdapterViewMvc {


    init {
        view = inflater.inflate(R.layout.list_item_movie, parent, false)
    }

    override fun bindMovies(popularMoveResult: PopularMovieResult, position: Int) {
        view.tvTitle.text = popularMoveResult.title
        view.tvScore.text = popularMoveResult.popularity.toString()
        view.ivPoster.setImageResource(popularMoveResult.posterPath)
        view.setOnClickListener {
            for (listener in listeners) {
                listener.onMovieItemClicked(position)
            }
        }
    }

}
