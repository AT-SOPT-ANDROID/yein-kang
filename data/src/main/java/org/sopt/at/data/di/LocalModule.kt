package org.sopt.at.data.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocalModule {
    private const val PREF_NAME = "tving_prefs"

    @Provides
    @Singleton
    fun provideUserSharedPreference(
        @ApplicationContext context: Context
    ): SharedPreferences {
        return context.getSharedPreferences(
            PREF_NAME, Context.MODE_PRIVATE
        )
    }
}