package org.sopt.at.repository

import org.sopt.at.entity.SignInEntity
import org.sopt.at.entity.SignUpEntity

interface UserRepository {
    fun saveUser(signUpEntity: SignUpEntity)
    fun getUser(): SignInEntity
    fun clearUserPreference()
}
