package com.lchowaniec.app_template.ui.main

import androidx.lifecycle.ViewModel
import com.lchowaniec.app_template.data.repository.auth.AuthRepository

class MainViewModel() : ViewModel()
{
    private val repository: AuthRepository? = AuthRepository().getInstance()

 val user by lazy{
     repository?.currentUser()
 }
    fun logout(){
        repository?.logout()
    }
}