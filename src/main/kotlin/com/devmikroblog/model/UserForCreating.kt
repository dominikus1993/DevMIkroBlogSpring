package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

/**
 * Created by domin_000 on 17.05.2016.
 */
class UserForCreating{
    public var username:String  =""
        @JsonProperty(access = JsonProperty.Access.READ_WRITE)
        get
        set

    public var password:String = ""
        @JsonProperty(access = JsonProperty.Access.READ_WRITE)
        get
        set

    public var confirmPassword:String = ""
        @JsonProperty(access = JsonProperty.Access.READ_WRITE)
        get
        set

    companion object{
        fun toUser(userForCreating: UserForCreating):User{
            val user = User()
            user.activated = true
            user.login = userForCreating.username
            user.role = Role.USER
            user.userPassword = userForCreating.password
            user.creationDate = Date()
            return user
        }
    }
}