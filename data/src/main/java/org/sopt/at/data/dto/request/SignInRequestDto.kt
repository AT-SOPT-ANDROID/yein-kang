package org.sopt.at.data.dto.request

import kotlinx.serialization.Serializable
import org.sopt.at.entity.SignInEntity

@Serializable
internal data class SignInRequestDto(
    val loginId: String,
    val password: String
)

internal fun SignInEntity.toDto() = SignInRequestDto(
    loginId = id,
    password = password
)