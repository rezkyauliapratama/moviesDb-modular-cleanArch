package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.rezkyauliapratama.featurehome.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller.PopularMovieAdapterController
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.model.RowPopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import timber.log.Timber
import javax.inject.Inject

class PopularMoviesAdapter @Inject constructor(
    private val viewMvcFactory: ViewMvcFactory,
    private val rowPopularMovieFactory: RowPopularMovieResult.Factory
) : RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>(),
    PopularMovieAdapterViewMvc.Listener {

    @Inject
    lateinit var popularMovieAdapterController: PopularMovieAdapterController

    private val mItems: ArrayList<RowPopularMovieResult> = ArrayList()

    fun bindMovies(popularMovies: List<PopularMovieResult>) {
        mItems.clear()
        if (popularMovies.isNotEmpty()) {
            val fetchItems = popularMovies.map { rowPopularMovieFactory.create(it) }
            Timber.e("fetchItems $fetchItems")
            mItems.addAll(fetchItems)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewMvc = viewMvcFactory.getPopularMovieAdapterViewMvc(parent)
        return ViewHolder(viewMvc)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        popularMovieAdapterController.bindViewAndRegistenerListener(holder.mViewMvc)
        popularMovieAdapterController.bindData(mItems[position], position)
    }

    override fun onMovieItemClicked(position: Int) {

    }

    class ViewHolder(val mViewMvc: PopularMovieAdapterViewMvc) : RecyclerView.ViewHolder(mViewMvc.view)
}
