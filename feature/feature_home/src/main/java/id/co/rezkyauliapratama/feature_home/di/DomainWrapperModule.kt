package id.co.rezkyauliapratama.feature_home.di

import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.feature_home.data.datasource.MovieDataSourceImpl
import id.co.rezkyauliapratama.feature_home.data.datasource.source.api.MoviesApi
import id.co.rezkyauliapratama.feature_home.data.datasource.source.datasource.MovieRemoteDataSource
import id.co.rezkyauliapratama.feature_home.data.repository.MovieRepositoryImpl
import id.co.rezkyauliapratama.feature_home.domain.repository.MovieRepository
import id.co.rezkyauliapratama.lib_core.di.ApiKey
import id.co.rezkyauliapratama.lib_network.services
import retrofit2.Retrofit


@Module
class RepositoryModule {

    @Provides
    fun provideMovieRepository(@ApiKey apiKey: String, movieRemoteDataSource: MovieRemoteDataSource): MovieRepository {
        return MovieRepositoryImpl(apiKey, movieRemoteDataSource)
    }

}

@Module
class DataSourcesModule {

    @Provides
    fun provideMovieRemoteDataSource(moviesApi: MoviesApi): MovieRemoteDataSource {
        return MovieDataSourceImpl(moviesApi)
    }

}

@Module
class NetworkModule {

    @Provides
    fun provideMovieApiService(retrofit: Retrofit): MoviesApi {
        return services(retrofit)
    }

}