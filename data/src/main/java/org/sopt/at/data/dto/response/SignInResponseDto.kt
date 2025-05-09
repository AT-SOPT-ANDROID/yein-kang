package org.sopt.at.data.dto.response

import kotlinx.serialization.Serializable
import org.sopt.at.entity.SignInUserEntity

@Serializable
data class SignInResponseDto(
    val userId: Long
) {
    fun toEntity() = SignInUserEntity(
        userId = userId
    )
}
