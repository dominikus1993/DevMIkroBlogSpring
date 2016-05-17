package com.devmikroblog.model

/**
 * Created by domin_000 on 17.05.2016.
 */
class UserForCreating{
    private lateinit var username:String
    private lateinit var password:String
    private lateinit var confirmPassword:String

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