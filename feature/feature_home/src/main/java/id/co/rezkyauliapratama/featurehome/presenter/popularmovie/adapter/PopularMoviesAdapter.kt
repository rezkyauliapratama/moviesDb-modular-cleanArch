package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import id.co.rezkyauliapratama.featurehome.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller.PopularMovieAdapterController
import javax.inject.Inject

class PopularMoviesAdapter @Inject constructor(
    private val viewMvcFactory: ViewMvcFactory
) : BaseAdapter(){

    @Inject
    lateinit var popularMovieAdapterController: PopularMovieAdapterController

    val items: ArrayList<PopularMovieResult> = arrayListOf()

    fun bind(items: List<PopularMovieResult>) {
        this.items.clear()
        if (items.isNotEmpty()) {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val popularMovieAdapterViewMvc = viewMvcFactory.getPopularMovieAdapterViewMvc(parent)
        popularMovieAdapterController.bind(popularMovieAdapterViewMvc, items, position)
        return popularMovieAdapterViewMvc.view
    }

    override fun getItem(position: Int): PopularMovieResult {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }

    override fun getCount(): Int {
        return items.size
    }


}