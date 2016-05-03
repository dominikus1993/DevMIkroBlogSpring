package com.devmikroblog.services.interfaces

import com.devmikroblog.model.Role
import com.devmikroblog.model.User

/**
 * Created by dominik on 03.05.16.
 */
interface IUserService {
    fun login(username:String, password:String): User?
    fun register(user: User):Boolean
    fun isAdmin(userId:Int):Boolean
    fun changeRole(userId: Int, role: Role):Boolean
    fun isOwner(postId: Int, userId: Int): Boolean
}