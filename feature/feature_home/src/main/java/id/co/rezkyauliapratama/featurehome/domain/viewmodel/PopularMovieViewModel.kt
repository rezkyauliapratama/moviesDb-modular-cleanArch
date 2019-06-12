package id.co.rezkyauliapratama.featurehome.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.co.rezkyauliapratama.featurehome.domain.pagination.PopularMoviePagingDataSource
import id.co.rezkyauliapratama.featurehome.domain.pagination.PopularMoviePagingDataSourceFactory
import id.co.rezkyauliapratama.featurehome.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.common.Resource
import id.co.rezkyauliapratama.libcore.presenter.viewmodels.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PopularMovieViewModel @Inject constructor(
    getPopularMovie: GetPopularMovie
) : BaseViewModel() {

    val moviesList: LiveData<PagedList<PopularMovieResult>>

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val popularMoviePagingDataSourceFactory: PopularMoviePagingDataSourceFactory =
        PopularMoviePagingDataSourceFactory(compositeDisposable, getPopularMovie)

    private val pageSize: Int = 5

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()

        moviesList = LivePagedListBuilder<Int, PopularMovieResult>(popularMoviePagingDataSourceFactory, config).build()
    }

    fun getState(): LiveData<Resource<PopularMovieResult>> = Transformations.switchMap(
        popularMoviePagingDataSourceFactory.pagingSourceLiveData,
        PopularMoviePagingDataSource::resources
    )

    fun listIsEmpty(): Boolean {
        return moviesList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
