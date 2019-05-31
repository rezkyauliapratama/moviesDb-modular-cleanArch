package id.co.rezkyauliapratama.lib_presenter.common.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(source: String?, requestOptions: RequestOptions? = null) {
    val requestBuilder = Glide.with(this.context)
        .load(source ?: "")
    requestOptions?.let {
        requestBuilder.apply(requestOptions)
    }
    requestBuilder.into(this)
}