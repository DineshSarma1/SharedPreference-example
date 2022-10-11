package com.example.daggerhiltmvvmpractice2.data

import android.content.SharedPreferences
import com.example.daggerhiltmvvmpractice2.constants.Constants

class SharedPrefHelper(
    private val preference: SharedPreferences
) {

    fun insertDataIntoPref(name: String) {
        preference.edit().putString(Constants.USER_NAME, name).apply()
    }

    fun getUserDataFromPref() : String? {
        return preference.getString(Constants.USER_NAME, "")
    }
}