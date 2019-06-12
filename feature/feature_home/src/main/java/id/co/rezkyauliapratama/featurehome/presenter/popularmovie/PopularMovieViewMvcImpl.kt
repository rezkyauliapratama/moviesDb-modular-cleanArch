package id.co.rezkyauliapratama.featurehome.presenter.popularmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.PopularMoviesAdapter
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.libcore.presenter.common.Resource
import id.co.rezkyauliapratama.libcore.presenter.views.BaseObservableViewMvc
import id.co.rezkyauliapratama.libuicomponent.common.ProgressDialogUtil
import kotlinx.android.synthetic.main.fragment_movie_list.view.*
import java.lang.ref.WeakReference

class PopularMovieViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, private val adapter: PopularMoviesAdapter) :
    BaseObservableViewMvc<PopularMovieViewMvc.Listener>(), PopularMovieViewMvc {

    init {
        view = inflater.inflate(R.layout.fragment_movie_list, parent, false)
        val layoutManager: GridLayoutManager = GridLayoutManager(view.context, 2)
        val lookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    PopularMoviesAdapter.DATA_VIEW_TYPE -> 1
                    else -> 2
                }
            }
        }

        layoutManager.spanSizeLookup = lookup

        view.rvPopularMovies.layoutManager = layoutManager
        view.rvPopularMovies.adapter = adapter

    }

    override fun submitList(pagedList: PagedList<PopularMovieResult>) {
        adapter.submitList(pagedList)
    }

    override fun submitState(resourceState: Resource<List<PopularMovieResult>>) {
        adapter.setResourceState(resourceState.state)
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
