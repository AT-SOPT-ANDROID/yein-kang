package org.sopt.at.repository

import org.sopt.at.entity.SignInEntity
import org.sopt.at.entity.SignInUserEntity
import org.sopt.at.entity.SignUpEntity
import org.sopt.at.entity.SignUpUserEntity

interface AuthRepository {
    suspend fun signUp(signUpEntity: SignUpEntity): Result<SignUpUserEntity?>

    suspend fun signIn(signInEntity: SignInEntity): Result<SignInUserEntity?>
}
