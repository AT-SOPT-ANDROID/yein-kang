package org.sopt.at.data.datasource

import org.sopt.at.data.dto.request.SignUpRequestDto
import org.sopt.at.data.service.AuthService
import javax.inject.Inject

internal class AuthDataSource @Inject constructor(
    private val authService: AuthService
) {
    suspend fun signUp(signUpRequest: SignUpRequestDto) = authService.signUp(signUpRequest)
}