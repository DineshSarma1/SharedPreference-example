package com.example.daggerhiltmvvmpractice2.repository

import com.example.daggerhiltmvvmpractice2.data.SharedPrefHelper

class UserRepositoryImpl(
    private val preference: SharedPrefHelper
): UserRepository {
    override fun insertUserData(name: String) {
        preference.insertDataIntoPref(name)
    }

    override fun getUserData(): String? {
        return preference.getUserDataFromPref()
    }
}