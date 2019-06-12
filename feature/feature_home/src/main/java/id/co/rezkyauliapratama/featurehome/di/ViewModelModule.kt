package id.co.rezkyauliapratama.featurehome.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.co.rezkyauliapratama.featurehome.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.libcore.di.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PopularMovieViewModel::class)
    abstract fun bindPopularViewModel(viewModel: PopularMovieViewModel): ViewModel

}
