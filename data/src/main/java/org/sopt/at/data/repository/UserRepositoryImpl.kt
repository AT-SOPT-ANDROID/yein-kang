package org.sopt.at.data.repository

import org.sopt.at.data.datasource.UserLocalDataSource
import org.sopt.at.data.datasource.UserRemoteDataSource
import org.sopt.at.entity.MyNicknameEntity
import org.sopt.at.entity.SignInUserEntity
import org.sopt.at.repository.UserRepository
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    override fun saveUser(signInUserData: SignInUserEntity) {
        userLocalDataSource.userId = signInUserData.userId
    }

    override fun getUser(): SignInUserEntity {
        return SignInUserEntity(
            userId = userLocalDataSource.userId
        )
    }

    override fun clearUserPreference() {
        userLocalDataSource.clearUserPreference()
    }

    override suspend fun getMyNickName(): Result<MyNicknameEntity> =
        runCatching {
            userRemoteDataSource.getMyNickName().data?.toEntity()
                ?: throw NullPointerException()
        }
}
