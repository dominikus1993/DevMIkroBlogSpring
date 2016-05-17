package com.devmikroblog.model

/**
 * Created by domin_000 on 17.05.2016.
 */
class UserForCreating{
    public  lateinit var username:String
    public  lateinit var password:String
    public  lateinit var confirmPassword:String

    companion object{
        fun toUser(userForCreating: UserForCreating):User{
            val user = User()
            user.activated = true
            user.login = userForCreating.username
            user.role = Role.USER
            user.userPassword = userForCreating.password
            return user
        }
    }
}