package com.devmikroblog.controllers

import com.devmikroblog.model.Result
import com.devmikroblog.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by dominik on 08.04.16.
 */
open class BaseController{
    @Autowired
    protected lateinit var userService: IUserService;

    protected fun isOwner(postId:Int, userId : Int) : Result<Boolean> {
        return userService.isOwner(postId, userId)
    }
}