package id.co.rezkyauliapratama.libcore.di

import dagger.Module
import dagger.Provides

@Module
class CoreModule(private val apiKey: String) {

    @Provides
    @ApiKey
    fun provideApiKey(): String {
        return apiKey
    }

}
