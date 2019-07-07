package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller

import android.os.Bundle
import androidx.navigation.Navigation
import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.libcore.presenter.controllers.adapter.BaseAdapterController

class PopularMovieAdapterController
    : BaseAdapterController<PopularMovieAdapterViewMvc, List<PopularMovieResult>>(),
    PopularMovieAdapterViewMvc.Listener {

    val itemData: ArrayList<PopularMovieResult> = arrayListOf()

    override fun bind(viewMvc: PopularMovieAdapterViewMvc, itemData: List<PopularMovieResult>?, position: Int) {
        mViewMvc = viewMvc
        mViewMvc.registerListener(this)

        if (itemData != null) {
            mViewMvc.bindMovies(itemData[position], position)
            this.itemData.addAll(itemData)
        }
    }

    override fun onMovieItemClicked(position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("DataResult", itemData[position])
        Navigation.findNavController(mViewMvc.view)
            .navigate(R.id.action_popularMovieFragment_to_detailMovieFragment, bundle)

    }

}