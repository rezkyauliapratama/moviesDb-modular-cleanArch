package id.co.rezkyauliapratama.feature_home.presenter.popularmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.feature_home.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.PopularMoviesAdapter
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.lib_uicomponent.common.ProgressDialogUtil
import id.co.rezkyauliapratama.lib_uicomponent.presenter.views.BaseObservableViewMvc
import kotlinx.android.synthetic.main.fragment_movie_list.view.*
import java.lang.ref.WeakReference

class PopularMovieViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, viewMvcFactory: ViewMvcFactory) :
    BaseObservableViewMvc<PopularMovieViewMvc.Listener>(), PopularMovieViewMvc {

    private var adapter: PopularMoviesAdapter

    init {
        view = inflater.inflate(R.layout.fragment_movie_list, parent, false)

        adapter = PopularMoviesAdapter(viewMvcFactory)

        view.rvPopularMovies.layoutManager = LinearLayoutManager(view.context)
        view.rvPopularMovies.adapter = adapter
    }

    override fun bindPopularMovies(movies: List<PopularMovieView>) {
        adapter.bindMovies(movies)
    }

    override fun showProgressBarPage() {
        ProgressDialogUtil.showProgressDialog(WeakReference(view.context))
    }

    override fun hideProgressBarPage() {
        ProgressDialogUtil.hideProgressDialog()
    }

}