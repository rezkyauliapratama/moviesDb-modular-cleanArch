package id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie.view.DetailPopularMovieViewMvc
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.views.BaseViewMvc
import kotlinx.android.synthetic.main.fragment_detail_movie.view.*

class DetailPopularMovieViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseViewMvc(), DetailPopularMovieViewMvc {

    init {
        view = inflater.inflate(R.layout.fragment_detail_movie, parent, false)

    }

    override fun bindData(popularMovieResult: PopularMovieResult) {
        view.tvTitle.text = popularMovieResult.title
        view.tvScore.text = popularMovieResult.popularity.toString()
        view.tvValueOverview.text = popularMovieResult.overview
        view.ivPoster.setImageResource(popularMovieResult.posterPath)
    }

}