package id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie.view

import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.views.ViewMvc

interface DetailPopularMovieViewMvc : ViewMvc {
    fun bindData(popularMovieResult: PopularMovieResult)
}