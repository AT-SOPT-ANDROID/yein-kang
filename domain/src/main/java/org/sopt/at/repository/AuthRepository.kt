package org.sopt.at.repository

import org.sopt.at.entity.SignUpEntity
import org.sopt.at.entity.SignUpUserEntity

interface AuthRepository {
    suspend fun signUp(signUpEntity: SignUpEntity): Result<SignUpUserEntity?>
}