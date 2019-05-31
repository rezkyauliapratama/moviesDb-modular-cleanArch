package id.co.rezkyauliapratama.feature_home.domain.usecase

import id.co.rezkyauliapratama.feature_home.domain.model.mapToPopularMovieList
import id.co.rezkyauliapratama.feature_home.domain.repository.MovieRepository
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.lib_network.common.ErrorTransformer
import id.co.rezkyauliapratama.lib_uicomponent.domain.interactors.reactivebase.SingleUseCase
import io.reactivex.Single

class GetPopularMovie(
    private val movieRepository: MovieRepository,
    private val errorTransformer: ErrorTransformer<List<PopularMovieView>>
) : SingleUseCase<List<PopularMovieView>>(errorTransformer) {

    companion object {
        const val pageNum: String = "pageNum"
    }

    override fun buildUseCaseSingle(data: Map<String, Any?>): Single<List<PopularMovieView>> {
        val pageNumber: Int = data[pageNum] as Int
        return movieRepository.
            getPopularMovies(pageNumber).
                map { it.mapToPopularMovieList() }
    }

}