package id.co.rezkyauliapratama.libcore.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides


@Module
class PresenterModule(private val activity: FragmentActivity) {

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context = activity

    @Provides
    fun provideActivity(): FragmentActivity = activity

}
