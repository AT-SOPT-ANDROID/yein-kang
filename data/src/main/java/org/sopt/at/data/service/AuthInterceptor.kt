package org.sopt.at.data.service

import okhttp3.Interceptor
import okhttp3.Response
import org.sopt.at.data.datasource.UserLocalDataSource
import javax.inject.Inject

internal class AuthInterceptor @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val authType = request.tag(AuthType::class.java) ?: AuthType.TOKEN

        when (authType) {
            AuthType.NO_AUTH -> {
                builder.addHeader("Content-Type", "application/json")
            }
            AuthType.TOKEN -> {
                builder.addHeader("Content-Type", "application/json")
                    .addHeader("userId", userLocalDataSource.userId.toString())
            }
        }
        return chain.proceed(builder.build())
    }
}

enum class AuthType {
    NO_AUTH,
    TOKEN
}