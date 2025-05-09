package org.sopt.at.data.repository

import org.sopt.at.data.datasource.AuthDataSource
import org.sopt.at.data.dto.request.toDto
import org.sopt.at.data.service.jsonToErrorMessage
import org.sopt.at.entity.ApiException
import org.sopt.at.entity.SignInEntity
import org.sopt.at.entity.SignInUserEntity
import org.sopt.at.entity.SignUpEntity
import org.sopt.at.entity.SignUpUserEntity
import org.sopt.at.repository.AuthRepository
import retrofit2.HttpException
import javax.inject.Inject

internal class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {

    override suspend fun signUp(signUpData: SignUpEntity): Result<SignUpUserEntity> =
        runCatching {
            val response = authDataSource.signUp(signUpData.toDto())

            if (!response.success || response.data == null) {
                throw ApiException(response.message)
            }

            response.data.toEntity()
        }.recoverCatching { throwable ->
            when (throwable) {
                is HttpException -> {
                    val errorBodyStr = throwable.response()?.errorBody()?.string()

                    val message = jsonToErrorMessage(errorBodyStr)
                        ?: "Unknown error"

                    throw ApiException(message)
                }

                else -> throw throwable
            }
        }

    override suspend fun signIn(signInEntity: SignInEntity): Result<SignInUserEntity?> =
        runCatching {
            val response = authDataSource.signIn(signInEntity.toDto())

            if (!response.success || response.data == null) {
                throw ApiException(response.message)
            }

            response.data.toEntity()
        }.recoverCatching { throwable ->
            when (throwable) {
                is HttpException -> {
                    val errorBodyStr = throwable.response()?.errorBody()?.string()

                    val message = jsonToErrorMessage(errorBodyStr)
                        ?: "Unknown error"

                    throw ApiException(message)
                }

                else -> throw throwable
            }
        }
}
