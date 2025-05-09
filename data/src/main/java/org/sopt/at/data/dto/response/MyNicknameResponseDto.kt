package org.sopt.at.data.dto.response

import kotlinx.serialization.Serializable
import org.sopt.at.entity.MyNicknameEntity

@Serializable
data class MyNicknameResponseDto(
    val nickname: String
) {
    fun toEntity() = MyNicknameEntity(
        nickname = nickname
    )
}
