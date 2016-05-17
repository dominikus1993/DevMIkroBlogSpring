package com.devmikroblog.controllers

import com.devmikroblog.model.Post
import com.devmikroblog.model.Result
import com.devmikroblog.services.interfaces.IPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.web.bind.annotation.*
import java.util.function.Predicate

/**
 * Created by dominik on 22.03.16.
 */

@RestController
@RequestMapping("/api/post")
class PostController : BaseController{
    private val service:IPostService


    @Autowired
    constructor(service: IPostService) : super(){
        this.service = service
    }

    @RequestMapping("getAll")
    fun getAll(): Result<List<Post>?> {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    fun getById(@PathVariable id:Int):Result<Post?>{
        return service.getBy(Predicate { x -> x.id == id });
    }

    @RequestMapping(value = "create", method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody post:Post):Result<Post?>{
        val createResult = service.create(post);
        if(createResult.isSuccess && createResult.value){
            return service.getBy(Predicate { x -> x.id == post.id })
        }
        else{
            return Result.ErrorWhenNoData(null)
        }
    }
}