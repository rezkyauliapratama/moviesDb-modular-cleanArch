package id.co.rezkyauliapratama.featurehome.domain.pagination

import androidx.paging.DataSource
import id.co.rezkyauliapratama.featurehome.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.viewmodels.SingleLiveEvent

class PopularMoviePagingDataSourceFactory(
    private val getPopularMovie: GetPopularMovie
) : DataSource.Factory<Int, PopularMovieResult>() {

    val pagingSourceLiveData = SingleLiveEvent<PopularMoviePagingDataSource>()

    override fun create(): DataSource<Int, PopularMovieResult> {
        val popularMoviePagingDataSource = PopularMoviePagingDataSource(getPopularMovie)
        pagingSourceLiveData.postValue(popularMoviePagingDataSource)
        return popularMoviePagingDataSource
    }

}