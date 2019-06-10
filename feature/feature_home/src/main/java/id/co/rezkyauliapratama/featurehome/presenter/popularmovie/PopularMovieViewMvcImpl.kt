package id.co.rezkyauliapratama.featurehome.presenter.popularmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.PopularMoviesAdapter
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.libcore.presenter.views.BaseObservableViewMvc
import id.co.rezkyauliapratama.libuicomponent.common.ProgressDialogUtil
import kotlinx.android.synthetic.main.fragment_movie_list.view.*
import java.lang.ref.WeakReference

class PopularMovieViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, private val adapter: PopularMoviesAdapter) :
    BaseObservableViewMvc<PopularMovieViewMvc.Listener>(), PopularMovieViewMvc {



    init {
        view = inflater.inflate(R.layout.fragment_movie_list, parent, false)
        view.rvPopularMovies.layoutManager = LinearLayoutManager(view.context)
        view.rvPopularMovies.adapter = adapter
    }

    override fun bindPopularMovies(movies: List<PopularMovieResult>) {
        adapter.bindMovies(movies)
    }

    override fun showProgressBarPage() {
        ProgressDialogUtil.showProgressDialog(WeakReference(view.context))
    }

    override fun hideProgressBarPage() {
        ProgressDialogUtil.hideProgressDialog()
    }

}
