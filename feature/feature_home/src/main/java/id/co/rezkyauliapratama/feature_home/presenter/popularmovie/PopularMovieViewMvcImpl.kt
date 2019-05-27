package id.co.rezkyauliapratama.feature_home.presenter.popularmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.lib_presenter.common.ProgressDialogUtil
import id.co.rezkyauliapratama.lib_presenter.presenter.views.BaseObservableViewMvc
import java.lang.ref.WeakReference

class PopularMovieViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<PopularMovieViewMvc.Listener>(), PopularMovieViewMvc {

    init {
        view = inflater.inflate(R.layout.fragment_movie_list, parent, false)
    }

    override fun bindPopularMovies(movies: List<PopularMovieView>) {

    }

    override fun showProgressBarPage() {
        ProgressDialogUtil.showProgressDialog(WeakReference(view.context))
    }

    override fun hideProgressBarPage() {
        ProgressDialogUtil.hideProgressDialog()
    }

}