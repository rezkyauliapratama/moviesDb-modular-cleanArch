package id.co.rezkyauliapratama.multimodulecleanarchkotlin.data.model

import com.squareup.moshi.Json
import id.co.rezkyauliapratama.multimodulecleanarchkotlin.domain.model.RefreshToken

data class RefreshTokenDto(
    @field:Json(name = "expires_at")
    val expiresAt: String,
    @field:Json(name = "request_token")
    val requestToken: String,
    val success: Boolean
)

fun RefreshTokenDto.mapToDomain(): RefreshToken = RefreshToken(requestToken)
