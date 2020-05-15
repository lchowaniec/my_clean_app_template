package com.lchowaniec.app_template.data.repository.auth

import com.lchowaniec.app_template.data.firebase.auth.FirebaseSource
import com.lchowaniec.app_template.data.persistence.AccountPropertiesDao
import com.lchowaniec.app_template.data.persistence.AuthTokenDao
import com.lchowaniec.app_template.session.SessionManager

class AuthRepository
{
    private var instance: AuthRepository? = null
    private var firebase: FirebaseSource? = FirebaseSource().getInstance()

    fun getInstance(): AuthRepository?{
        if(instance == null){
            instance = AuthRepository()
        }
        return instance
    }
    fun login(email: String, password: String) = firebase?.login(email,password)
    fun register(email: String,password: String, username: String) = firebase?.register(email,password,username)
    fun currentUser() = firebase?.currentUser()
    fun logout() = firebase?.logout()
    fun resetPassword(email: String) = firebase?.resetPassword(email)
}