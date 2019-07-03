package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.co.rezkyauliapratama.featurehome.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller.LoaderFooterAdapterController
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller.PopularMovieAdapterController
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.model.RowPopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.libcore.presenter.common.ResourceState
import id.co.rezkyauliapratama.libuicomponent.adapter.LoaderAdapterViewMvc
import javax.inject.Inject

class PopularMoviesAdapter @Inject constructor(
    private val viewMvcFactory: ViewMvcFactory,
    private val rowPopularMovieResultFactory: RowPopularMovieResult.Factory
) : PagedListAdapter<PopularMovieResult, RecyclerView.ViewHolder>(popularMoviesDiffCallback),
    PopularMovieAdapterViewMvc.Listener {

    companion object {

        const val DATA_VIEW_TYPE = 1
        const val FOOTER_VIEW_TYPE = 2

        val popularMoviesDiffCallback = object : DiffUtil.ItemCallback<PopularMovieResult>() {
            override fun areItemsTheSame(oldItem: PopularMovieResult, newItem: PopularMovieResult): Boolean {
                return oldItem.genreIds == newItem.genreIds
            }

            override fun areContentsTheSame(oldItem: PopularMovieResult, newItem: PopularMovieResult): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var resourceState: ResourceState = ResourceState.LOADING

    @Inject
    lateinit var popularMovieAdapterController: PopularMovieAdapterController

    @Inject
    lateinit var loaderFooterAdapterController: LoaderFooterAdapterController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val popularMovieAdapterViewMvc = viewMvcFactory.getPopularMovieAdapterViewMvc(parent)
        val loaderAdapterViewMvc = viewMvcFactory.getLoaderAdapterViewMvc(parent)

        return if (viewType == DATA_VIEW_TYPE) PopularMovieViewHolder(popularMovieAdapterViewMvc) else LoaderViewHolder(
            loaderAdapterViewMvc
        )
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean {
        return super.getItemCount() != 0 && (resourceState == ResourceState.LOADING || resourceState == ResourceState.ERROR)
    }

    fun setResourceState(resourceState: ResourceState) {
        this.resourceState = resourceState
        notifyItemChanged(super.getItemCount())
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == DATA_VIEW_TYPE) {
            getItem(position)?.apply {
                val rowPopularMovieResult = rowPopularMovieResultFactory.create(this)
                popularMovieAdapterController.bind(
                    (holder as PopularMovieViewHolder).mViewMvc,
                    rowPopularMovieResult,
                    position
                )
            }
        } else loaderFooterAdapterController.bind((holder as LoaderViewHolder).mViewMvc, resourceState, position)
    }

    override fun onMovieItemClicked(position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) DATA_VIEW_TYPE else FOOTER_VIEW_TYPE
    }

}

class PopularMovieViewHolder(val mViewMvc: PopularMovieAdapterViewMvc) : RecyclerView.ViewHolder(mViewMvc.view)

class LoaderViewHolder(val mViewMvc: LoaderAdapterViewMvc) :
    RecyclerView.ViewHolder(mViewMvc.view)