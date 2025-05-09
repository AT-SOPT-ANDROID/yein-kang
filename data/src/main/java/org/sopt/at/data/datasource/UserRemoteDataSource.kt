package org.sopt.at.data.datasource

import org.sopt.at.data.service.UserService
import javax.inject.Inject

internal class UserRemoteDataSource @Inject constructor(
    private val userService: UserService
) {
    suspend fun getMyNickName() = userService.getMyNickName()
}
