package org.sopt.at.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponseDto<T>(
    val success: Boolean,
    val code: String,
    val message: String,
    val data: T?
)