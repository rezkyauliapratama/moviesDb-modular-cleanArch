package id.co.rezkyauliapratama.feature_home.domain.usecase

import id.co.rezkyauliapratama.feature_home.domain.model.mapToPopularMovieList
import id.co.rezkyauliapratama.feature_home.domain.repository.MovieRepository
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.lib_core.domain.common.NetworkSchedulerTransformer
import id.co.rezkyauliapratama.lib_core.domain.interactors.reactivebase.SingleUseCase
import id.co.rezkyauliapratama.lib_core.errorhandler.ErrorTransformer
import io.reactivex.Single
import javax.inject.Inject

class GetPopularMovie @Inject constructor(
    private val movieRepository: MovieRepository,
    errorTransformer: ErrorTransformer<List<PopularMovieView>>,
    networkSchedulerTransformer: NetworkSchedulerTransformer<List<PopularMovieView>>
) : SingleUseCase<List<PopularMovieView>>(networkSchedulerTransformer, errorTransformer) {

    companion object {
        const val pageNum: String = "pageNum"
    }

    override fun buildUseCaseSingle(data: Map<String, Any?>): Single<List<PopularMovieView>> {
        val pageNumber: Int = data[pageNum] as Int
        return movieRepository.getPopularMovies(pageNumber).map {
            it.mapToPopularMovieList()
        }
    }

}