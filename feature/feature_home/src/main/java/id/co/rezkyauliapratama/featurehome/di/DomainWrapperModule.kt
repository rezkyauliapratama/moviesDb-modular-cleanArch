package id.co.rezkyauliapratama.featurehome.di

import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.featurehome.data.datasource.MovieDataSource
import id.co.rezkyauliapratama.featurehome.data.datasource.MovieDataSourceManager
import id.co.rezkyauliapratama.featurehome.data.datasource.source.mock.MovieMockDataSource
import id.co.rezkyauliapratama.featurehome.data.datasource.source.mock.MovieMockDataSourceImpl
import id.co.rezkyauliapratama.featurehome.data.repository.MovieRepositoryImpl
import id.co.rezkyauliapratama.featurehome.domain.repository.MovieRepository


@Module
class RepositoryModule {

    @Provides
    fun provideMovieRepository(dataSource: MovieDataSource): MovieRepository {
        return MovieRepositoryImpl(dataSource)
    }

}

@Module
class DataSourcesModule {


    @Provides
    fun provideMovieMockDataSource(): MovieMockDataSource {
        return MovieMockDataSourceImpl()
    }

    @Provides
    fun provideDataSourceManager(
        movieMockDataSource: MovieMockDataSource
    ): MovieDataSource {
        return MovieDataSourceManager(movieMockDataSource)
    }

}
