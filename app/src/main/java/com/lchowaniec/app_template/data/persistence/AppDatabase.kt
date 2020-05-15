package com.lchowaniec.app_template.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lchowaniec.app_template.data.models.AccountProperties
import com.lchowaniec.app_template.data.models.AuthToken


@Database(entities = [AuthToken::class, AccountProperties::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getAuthTokenDao(): AuthTokenDao

    abstract fun getAccountPropertiesDao(): AccountPropertiesDao

    companion object{

        const val  DATABASE_NAME = "app_db"
    }

}