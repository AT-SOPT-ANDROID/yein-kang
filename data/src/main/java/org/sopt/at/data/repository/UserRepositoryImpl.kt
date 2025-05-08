package org.sopt.at.data.repository

import org.sopt.at.data.datasource.UserDataSource
import org.sopt.at.entity.SignInEntity
import org.sopt.at.entity.SignUpEntity
import org.sopt.at.repository.UserRepository
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {
    override fun saveUser(signUpEntity: SignUpEntity) {
        userDataSource.id = signUpEntity.id
        userDataSource.password = signUpEntity.password
    }

    override fun getUser(): SignInEntity {
        return SignInEntity(
            id = userDataSource.id, password = userDataSource.password
        )
    }

    override fun clearUserPreference() {
        userDataSource.clearUserPreference()
    }

}
