package com.devmikroblog.controllers

import com.devmikroblog.model.Result
import com.devmikroblog.model.User
import com.devmikroblog.model.UserForCreating
import com.devmikroblog.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
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
}