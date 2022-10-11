package com.example.daggerhiltmvvmpractice2.repository

interface UserRepository {

    fun insertUserData(name: String)
    fun getUserData() : String?
}