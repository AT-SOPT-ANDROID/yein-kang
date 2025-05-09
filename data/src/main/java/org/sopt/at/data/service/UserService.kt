package org.sopt.at.data.service

import org.sopt.at.data.dto.response.BaseResponseDto
import org.sopt.at.data.dto.response.MyNicknameResponseDto
import retrofit2.http.GET


internal interface UserService {
    @GET("users/me")
    suspend fun getMyNickName(): BaseResponseDto<MyNicknameResponseDto>
}