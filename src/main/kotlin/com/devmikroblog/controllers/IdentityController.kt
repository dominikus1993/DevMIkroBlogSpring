package com.devmikroblog.controllers

import com.devmikroblog.model.Result
import com.devmikroblog.model.Role
import com.devmikroblog.model.User
import com.devmikroblog.model.UserForCreating
import com.devmikroblog.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.web.bind.annotation.*
import java.security.Principal

/**
 * Created by dominik on 27.03.16.
 */
@RestController
@RequestMapping("/api/auth")
class IdentityController : BaseController() {

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "getLoggedUser")
    fun user(principal: Principal):Result<User?>{
        return getUser(principal);
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST), value = "register")
    fun register(@RequestBody user:UserForCreating) : Result<Boolean> {
        return userService.register(user)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "getAllUsers")
    fun getAll(principal: Principal): Result<List<User>?>{
        val user = getUser(principal)
        return userService.getAll(user.value as User)
    }

    @RequestMapping(method = arrayOf(RequestMethod.DELETE), value = "deleteUser/{userId}")
    fun delete(@PathVariable userId:Int, principal: Principal): Result<Boolean>{
        val user = getUser(principal)
        if(user.isSuccess){
            return userService.deleteUser(userId, user.value as User)
        }
        return Result(false)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "changeRole/{userId}/{role}")
    fun changeRole(@PathVariable("userId") userId: Int, @PathVariable("role") role:String, principal: Principal):Result<Boolean>{
        val roleEnum = Role.valueOf(role)
        val user = getUser(principal)
        if(user.isSuccess){
            return userService.changeRole(userId, roleEnum, user.value as User)
        }
        return Result(false)
    }
}