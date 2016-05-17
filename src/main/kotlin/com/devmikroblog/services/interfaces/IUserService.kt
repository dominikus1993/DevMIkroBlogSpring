package com.devmikroblog.services.interfaces

import com.devmikroblog.model.Result
import com.devmikroblog.model.Role
import com.devmikroblog.model.User
import com.devmikroblog.model.UserForCreating

/**
 * Created by dominik on 03.05.16.
 */
interface IUserService {
    fun login(username:String, password:String): Result<User?>
    fun register(user: UserForCreating):Result<Boolean>
    fun isAdmin(userId:Int):Result<Boolean>
    fun changeRole(userId: Int, role: Role): Result<Boolean>
    fun isOwner(postId: Int, userId: Int): Result<Boolean>
}