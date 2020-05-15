package com.lchowaniec.app_template.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_properties")
data class AccountProperties (

@PrimaryKey(autoGenerate = false)
@ColumnInfo(name = "pk")
var pk: Int,

@ColumnInfo(name = "email")
var email: String,

@ColumnInfo(name = "username")
var username: String
)