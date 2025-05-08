package org.sopt.at.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.at.data.repository.AuthRepositoryImpl
import org.sopt.at.data.repository.UserRepositoryImpl
import org.sopt.at.repository.AuthRepository
import org.sopt.at.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}
