package id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.data.model

import com.squareup.moshi.Json
import id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.domain.model.RefreshToken

data class RefreshTokenDto(
    @field:Json(name = "expires_at")
    val expiresAt: String,
    @field:Json(name = "request_token")
    val requestToken: String,
    val success: Boolean
)

fun RefreshTokenDto.mapToDomain(): RefreshToken = RefreshToken(requestToken)