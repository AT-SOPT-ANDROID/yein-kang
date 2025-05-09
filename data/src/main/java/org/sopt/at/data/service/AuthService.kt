package org.sopt.at.data.service

import org.sopt.at.data.dto.request.SignInRequestDto
import org.sopt.at.data.dto.request.SignUpRequestDto
import org.sopt.at.data.dto.response.BaseResponseDto
import org.sopt.at.data.dto.response.SignInResponseDto
import org.sopt.at.data.dto.response.SignUpResponseDto
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Tag

internal interface AuthService {
    @POST("auth/signup")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequestDto,
        @Tag authType: AuthType = AuthType.NO_AUTH
    ): BaseResponseDto<SignUpResponseDto>

    @POST("auth/signin")
    suspend fun signIn(
        @Body signInRequest: SignInRequestDto,
        @Tag authType: AuthType = AuthType.NO_AUTH
    ): BaseResponseDto<SignInResponseDto>
}

