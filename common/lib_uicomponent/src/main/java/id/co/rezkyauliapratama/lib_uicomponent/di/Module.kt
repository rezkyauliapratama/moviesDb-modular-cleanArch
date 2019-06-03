package id.co.rezkyauliapratama.lib_uicomponent.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.lib_uicomponent.data.executors.JobExecutor
import id.co.rezkyauliapratama.lib_uicomponent.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_uicomponent.domain.executors.ThreadExecutor
import id.co.rezkyauliapratama.lib_uicomponent.presenter.UIThread

@Module
class PresenterModule(private val activity: FragmentActivity) {

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context = activity

    @Provides
    fun provideActivity(): FragmentActivity = activity

}

@Module
class SchedulerModule {

    @Provides
    fun providesThreadExecutor() : ThreadExecutor {
        return JobExecutor()
    }

    @Provides
    fun provides(): PostExecutionThread {
        return UIThread()
    }
}

@Module
class GlideModule {

    @Provides
    fun providesGlide(@ActivityContext context: Context): RequestManager{
        return Glide.with(context)
    }

}