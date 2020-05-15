package com.lchowaniec.app_template.session

import android.app.Application
import com.lchowaniec.app_template.data.persistence.AuthTokenDao

class SessionManager
constructor(
    val authTokenDao: AuthTokenDao,
    val application: Application
)
{

}