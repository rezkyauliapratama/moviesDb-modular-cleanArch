package id.co.rezkyauliapratama.featurehome.domain.pagination

import id.co.rezkyauliapratama.featurehome.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.domain.pagination.BasePageKeyedDataSource
import id.co.rezkyauliapratama.libcore.presenter.common.Resource
import id.co.rezkyauliapratama.libcore.presenter.common.setError
import id.co.rezkyauliapratama.libcore.presenter.common.setLoading
import id.co.rezkyauliapratama.libcore.presenter.common.setSuccess
import id.co.rezkyauliapratama.libcore.presenter.viewmodels.SingleLiveEvent
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class PopularMoviePagingDataSource(
    private val compositeDisposable: CompositeDisposable,
    private val getPopularMovie: GetPopularMovie
) : BasePageKeyedDataSource<Int, PopularMovieResult>() {


    override fun compositeDisposable(): CompositeDisposable = compositeDisposable

    var resources: SingleLiveEvent<Resource<List<PopularMovieResult>>> = SingleLiveEvent()

    private val initialPage = 1
    private val adjacentPage = 1

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PopularMovieResult>) {
        resources.setLoading()

        loadPopularMovies(initialPage).subscribe(
            { response ->
                resources.setSuccess(response)
                callback.onResult(response, null, initialPage + adjacentPage)
            },
            {
                resources.setError(it)
            }).track()
    }

    private fun loadPopularMovies(page: Int): Single<List<PopularMovieResult>> {
        return getPopularMovie.execute(
            mapOf(
                GetPopularMovie.pageNum to page
            )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PopularMovieResult>) {
        resources.setLoading()

        loadPopularMovies(params.key).subscribe(
            { response ->
                resources.setSuccess(response)
                callback.onResult(response, params.key + adjacentPage)
            },
            {
                resources.setError(it)
            }
        ).track()
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PopularMovieResult>) {

    }

}