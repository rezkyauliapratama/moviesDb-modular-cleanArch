package id.co.rezkyauliapratama.feature_home.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.lib_uicomponent.di.viewmodel.ViewModelKey

@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(PopularMovieViewModel::class)
    abstract fun bindPopularViewModel(viewModel: PopularMovieViewModel) : ViewModel

}