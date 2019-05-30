package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.rezkyauliapratama.feature_home.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc

class PopularMoviesAdapter(private val viewMvcFactory: ViewMvcFactory) :
    RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>(), PopularMovieAdapterViewMvc.Listener {

    private val mItems: ArrayList<PopularMovieView> = ArrayList()

    fun bindMovies(popularMovies: List<PopularMovieView>){
        mItems.clear()
        if (popularMovies.isNotEmpty()){
            mItems.addAll(popularMovies)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewMvc = viewMvcFactory.getPopularMovieAdapterViewMvc(parent)
        viewMvc.registerListener(this)
        return ViewHolder(viewMvc)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mViewMvc.bindMovies(mItems[position], position)
    }

    override fun onMovieItemClicked(position: Int) {

    }

    class ViewHolder(val mViewMvc: PopularMovieAdapterViewMvc) : RecyclerView.ViewHolder(mViewMvc.view)
}