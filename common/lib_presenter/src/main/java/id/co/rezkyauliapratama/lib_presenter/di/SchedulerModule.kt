package id.co.rezkyauliapratama.lib_presenter.di

import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.lib_presenter.data.executors.JobExecutor
import id.co.rezkyauliapratama.lib_presenter.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_presenter.domain.executors.ThreadExecutor
import id.co.rezkyauliapratama.lib_presenter.presenter.UIThread
import javax.inject.Singleton

@Module
class SchedulerModule {

    @Singleton
    @Provides
    fun providesThreadExecutor() : ThreadExecutor {
        return JobExecutor()
    }

    @Singleton
    @Provides
    fun providesPostExecutionThread() : PostExecutionThread {
        return UIThread()
    }
}