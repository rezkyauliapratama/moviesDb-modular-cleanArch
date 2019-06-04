package id.co.rezkyauliapratama.feature_home.domain.usecase

import com.squareup.moshi.Moshi
import id.co.rezkyauliapratama.feature_home.data.datasource.model.ListMoviesDto
import id.co.rezkyauliapratama.feature_home.domain.model.MovieModel
import id.co.rezkyauliapratama.feature_home.domain.model.mapToPopularMovieList
import id.co.rezkyauliapratama.feature_home.domain.repository.MovieRepository
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.lib_core.errorhandler.ErrorTransformer
import id.co.rezkyauliapratama.lib_uicomponent.domain.common.NetworkSchedulerTransformer
import id.co.rezkyauliapratama.lib_uicomponent.domain.interactors.reactivebase.SingleUseCase
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class GetPopularMovie @Inject constructor(
    private val movieRepository: MovieRepository,
    errorTransformer: ErrorTransformer<List<PopularMovieView>>,
    networkSchedulerTransformer: NetworkSchedulerTransformer<List<PopularMovieView>>
) : SingleUseCase<List<PopularMovieView>>(networkSchedulerTransformer,errorTransformer) {

    companion object {
        const val pageNum: String = "pageNum"
    }

    override fun buildUseCaseSingle(data: Map<String, Any?>): Single<List<PopularMovieView>> {
        val pageNumber: Int = data[pageNum] as Int
        return movieRepository.
            getPopularMovies(pageNumber).
                map {
                    it.mapToPopularMovieList()
                }
    }

}