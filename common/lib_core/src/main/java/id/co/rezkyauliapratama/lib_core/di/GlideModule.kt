package id.co.rezkyauliapratama.lib_core.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides


@Module
class GlideModule {

    @Provides
    fun providesGlide(@ActivityContext context: Context): RequestManager {
        return Glide.with(context)
    }

}