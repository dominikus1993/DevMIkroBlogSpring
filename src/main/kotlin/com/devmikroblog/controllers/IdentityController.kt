package com.devmikroblog.controllers

import com.devmikroblog.model.Result
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


    fun user(user:Principal):Principal{
        return user;
    }
    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "register")
    fun register(@RequestBody user:UserForCreating) : Result<Boolean> {
        return userService.register(UserForCreating.toUser(user))
    }
}