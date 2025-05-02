package org.sopt.at.data.datasource

import android.content.SharedPreferences
import javax.inject.Inject
import androidx.core.content.edit

internal class UserDataSource @Inject constructor(
    private val userSharedPreference: SharedPreferences
) {
    var id: String
        get() = userSharedPreference.getString(ID, "").toString()
        set(value) = userSharedPreference.edit{ putString(ID, value) }

    var password: String
        get() = userSharedPreference.getString(PASSWORD, "").toString()
        set(value) = userSharedPreference.edit{ putString(PASSWORD, value) }

    fun clearUserPreference() {
        id = DEFAULT_STRING
        password = DEFAULT_STRING
        userSharedPreference.edit{ clear() }
    }

    companion object {
        private const val ID = "id"
        private const val PASSWORD = "password"
        private const val DEFAULT_STRING = ""
    }
}

