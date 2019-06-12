package id.co.rezkyauliapratama.featurehome.domain.usecase

import id.co.rezkyauliapratama.featurehome.domain.model.mapToPopularMovieList
import id.co.rezkyauliapratama.featurehome.domain.repository.MovieRepository
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.domain.common.NetworkSchedulerTransformer
import id.co.rezkyauliapratama.libcore.domain.interactors.reactivebase.SingleUseCase
import id.co.rezkyauliapratama.libcore.errorhandler.ErrorTransformer
import io.reactivex.Single
import javax.inject.Inject

class GetPopularMovie @Inject constructor(
    private val movieRepository: MovieRepository,
    errorTransformer: ErrorTransformer<List<PopularMovieResult>>,
    networkSchedulerTransformer: NetworkSchedulerTransformer<List<PopularMovieResult>>
) : SingleUseCase<List<PopularMovieResult>>(networkSchedulerTransformer, errorTransformer) {

    companion object {
        const val pageNum: String = "pageNum"
    }

    override fun buildUseCaseSingle(data: Map<String, Any?>): Single<List<PopularMovieResult>> {
        val pageNumber: Int = data[pageNum] as Int
        return movieRepository.getPopularMovies(pageNumber).map {
            it.mapToPopularMovieList()
        }
    }

}
