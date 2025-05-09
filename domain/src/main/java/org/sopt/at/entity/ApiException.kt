package org.sopt.at.entity

data class ApiException(
    override val message: String
) : Exception(message)
