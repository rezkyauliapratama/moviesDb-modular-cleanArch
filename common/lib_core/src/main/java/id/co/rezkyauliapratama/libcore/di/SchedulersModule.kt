package id.co.rezkyauliapratama.libcore.di

import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.libcore.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.libcore.domain.executors.ThreadExecutor
import id.co.rezkyauliapratama.libcore.presenter.UIThread
import id.co.rezkyauliapratama.libcore.data.executors.JobExecutor

@Module
class SchedulersModule {

    @Provides
    fun providesThreadExecutor() : ThreadExecutor {
        return JobExecutor()
    }

    @Provides
    fun provides(): PostExecutionThread {
        return UIThread()
    }
}
