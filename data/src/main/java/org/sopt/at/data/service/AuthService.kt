package org.sopt.at.data.service

import org.sopt.at.data.dto.request.SignUpRequestDto
import org.sopt.at.data.dto.response.BaseResponseDto
import org.sopt.at.data.dto.response.SignUpResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AuthService {
    @POST("auth/signup")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequestDto
    ): BaseResponseDto<SignUpResponseDto>
}

