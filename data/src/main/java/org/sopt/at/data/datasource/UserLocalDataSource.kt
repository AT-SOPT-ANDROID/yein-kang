package org.sopt.at.data.datasource

import android.content.SharedPreferences
import javax.inject.Inject
import androidx.core.content.edit

internal class UserLocalDataSource @Inject constructor(
    private val userSharedPreference: SharedPreferences
) {
    var id: String
        get() = userSharedPreference.getString(ID, "").toString()
        set(value) = userSharedPreference.edit { putString(ID, value) }

    var password: String
        get() = userSharedPreference.getString(PASSWORD, "").toString()
        set(value) = userSharedPreference.edit { putString(PASSWORD, value) }

    var userId: Long
        get() = userSharedPreference.getLong(USER_ID, -1)
        set(value) = userSharedPreference.edit { putLong("userId", value) }


    fun clearUserPreference() {
        id = DEFAULT_STRING
        password = DEFAULT_STRING
        userId = -1
        userSharedPreference.edit { clear() }
    }

    companion object {
        private const val ID = "id"
        private const val PASSWORD = "password"
        private const val USER_ID = "userId"
        private const val DEFAULT_STRING = ""
    }
}
