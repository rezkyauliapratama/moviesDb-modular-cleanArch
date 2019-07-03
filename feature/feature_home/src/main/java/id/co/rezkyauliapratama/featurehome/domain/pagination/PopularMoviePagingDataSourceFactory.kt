package id.co.rezkyauliapratama.featurehome.domain.pagination

import androidx.paging.DataSource
import id.co.rezkyauliapratama.featurehome.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.viewmodels.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

class PopularMoviePagingDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val getPopularMovie: GetPopularMovie
) : DataSource.Factory<Int, PopularMovieResult>() {

    val pagingSourceLiveData = SingleLiveEvent<PopularMoviePagingDataSource>()

    override fun create(): DataSource<Int, PopularMovieResult> {
        val popularMoviePagingDataSource = PopularMoviePagingDataSource(compositeDisposable, getPopularMovie)
        pagingSourceLiveData.postValue(popularMoviePagingDataSource)
        return popularMoviePagingDataSource
    }


}