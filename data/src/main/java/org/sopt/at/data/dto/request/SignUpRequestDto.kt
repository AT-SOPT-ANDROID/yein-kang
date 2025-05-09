package org.sopt.at.data.dto.request

import kotlinx.serialization.Serializable
import org.sopt.at.entity.SignUpEntity

@Serializable
internal data class SignUpRequestDto(
    val loginId: String,
    val nickname: String,
    val password: String
)

internal fun SignUpEntity.toDto() = SignUpRequestDto(
    loginId = loginId,
    nickname = nickname,
    password = password
)