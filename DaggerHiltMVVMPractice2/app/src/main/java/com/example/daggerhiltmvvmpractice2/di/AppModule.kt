package com.example.daggerhiltmvvmpractice2.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.daggerhiltmvvmpractice2.constants.Constants
import com.example.daggerhiltmvvmpractice2.data.SharedPrefHelper
import com.example.daggerhiltmvvmpractice2.repository.UserRepository
import com.example.daggerhiltmvvmpractice2.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreference(context: Application) : SharedPrefHelper {
        return SharedPrefHelper(context.getSharedPreferences(Constants.PREF_NAME,Context.MODE_PRIVATE))
    }

    @Provides
    @Singleton
    fun provideUserRepository(pref: SharedPrefHelper): UserRepository {
        return UserRepositoryImpl(pref)
    }
}