package com.devmikroblog.repositories.interfaces

import com.devmikroblog.model.Role
import com.devmikroblog.model.User

/**
 * Created by dominik on 12.04.16.
 */

public interface IUserRepository : ICrudable<User>{
    fun login(username:String, password:String): User?
    fun register(user: User):Boolean
    fun isAdmin(userId:Int):Boolean
    fun changeRole(userId: Int, role: Role):Boolean
    fun isOwner(postId: Int, userId: Int): Boolean
}
