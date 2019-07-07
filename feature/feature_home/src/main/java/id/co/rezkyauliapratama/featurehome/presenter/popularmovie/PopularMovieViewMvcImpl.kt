package id.co.rezkyauliapratama.featurehome.presenter.popularmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
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

        view.listView.adapter = adapter

    }

    override fun submitList(items: List<PopularMovieResult>) {
        adapter.bind(items)
    }

    override fun showProgressBarPage() {
        ProgressDialogUtil.showProgressDialog(WeakReference(view.context))
    }

    override fun hideProgressBarPage() {
        ProgressDialogUtil.hideProgressDialog()
    }

    override fun displayError(throwable: Throwable?) {
        Snackbar.make(view, "There's an error on the API", Snackbar.LENGTH_LONG).show()
    }
}
