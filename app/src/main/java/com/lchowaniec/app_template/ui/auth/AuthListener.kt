package com.lchowaniec.app_template.ui.auth

interface AuthListener {
    fun onSuccess()
    fun onStarted()
    fun onFailure(message:String)
}