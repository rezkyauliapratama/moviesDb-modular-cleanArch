package id.co.rezkyauliapratama.featurehome.presenter.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularMovieResult(
    val id: Long,
    val title: String,
    val popularity: Double,
    val posterPath: Int,
    val releaseDate: String,
    val overview: String
) : Parcelable
