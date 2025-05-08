package org.sopt.at.repository

import org.sopt.at.entity.SignInUserEntity

interface UserRepository {
    fun saveUser(signInUserData: SignInUserEntity)
    fun getUser(): SignInUserEntity
    fun clearUserPreference()
}
