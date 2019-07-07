package id.co.rezkyauliapratama.featurehome.domain.usecase

import id.co.rezkyauliapratama.featurehome.domain.model.mapToPopularMovieList
import id.co.rezkyauliapratama.featurehome.domain.repository.MovieRepository
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.domain.common.NetworkSchedulerTransformer
import id.co.rezkyauliapratama.libcore.domain.interactors.reactivebase.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPopularMovie @Inject constructor(
    private val movieRepository: MovieRepository,
    networkSchedulerTransformer: NetworkSchedulerTransformer<List<PopularMovieResult>>
) : SingleUseCase<List<PopularMovieResult>>(networkSchedulerTransformer) {

    override fun buildUseCaseSingle(data: Map<String, Any?>): Single<List<PopularMovieResult>> {
        return movieRepository.getPopularMovies().map {
            it.mapToPopularMovieList()
        }
    }

}
