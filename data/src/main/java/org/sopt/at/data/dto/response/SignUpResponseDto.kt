package org.sopt.at.data.dto.response

import kotlinx.serialization.Serializable
import org.sopt.at.entity.SignUpUserEntity

@Serializable
data class SignUpResponseDto(
    val userId: Int,
    val nickname: String
) {
    fun toEntity() = SignUpUserEntity(
        userId = userId,
        nickname = nickname
    )
}