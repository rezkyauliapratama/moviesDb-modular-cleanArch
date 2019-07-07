package id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie.controller

import id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie.view.DetailPopularMovieViewMvc
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.controllers.BaseController

class DetailPopularMovieController : BaseController<DetailPopularMovieViewMvc>() {

    fun bind(detailPopularMovieViewMvc: DetailPopularMovieViewMvc, popularMovieResult: PopularMovieResult?) {
        mViewMvc = detailPopularMovieViewMvc

        if (popularMovieResult != null) {
            mViewMvc.bindData(popularMovieResult)
        }
    }


}