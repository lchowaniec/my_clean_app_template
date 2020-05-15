package com.lchowaniec.app_template.util

import android.content.Context
import android.content.Intent
import com.lchowaniec.app_template.ui.auth.AuthActivity
import com.lchowaniec.app_template.ui.main.MainActivity

fun Context.startMainActivity() =
    Intent(this, MainActivity::class.java ).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)

    }
fun Context.startAuthActivity() =
    Intent(this, AuthActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent. FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }