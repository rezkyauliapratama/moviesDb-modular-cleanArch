package id.co.rezkyauliapratama.featurehome.di

import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.featurehome.data.datasource.MovieDataSourceImpl
import id.co.rezkyauliapratama.featurehome.data.datasource.source.api.MoviesApi
import id.co.rezkyauliapratama.featurehome.data.datasource.source.datasource.MovieRemoteDataSource
import id.co.rezkyauliapratama.featurehome.data.repository.MovieRepositoryImpl
import id.co.rezkyauliapratama.featurehome.domain.repository.MovieRepository
import id.co.rezkyauliapratama.libcore.di.ApiKey
import id.co.rezkyauliapratama.libnetwork.services
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
