package com.lchowaniec.app_template.data.models

class User(){
    var user_id:String= ""
    var email:String= ""
    var username :String = ""
    var description: String = ""
    var distance: Float = 0F
    var friends: Int = 0
    var activities: Int =0
    var profile_photo :String = ""
    var last_online:Long = 0L
    constructor(user_id: String, email: String, username: String ): this() {
        this.user_id = user_id
        this.email = email
        this.username = username
    }


}

