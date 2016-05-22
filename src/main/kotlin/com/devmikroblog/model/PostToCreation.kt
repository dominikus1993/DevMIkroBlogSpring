package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

/**
 * Created by domin_000 on 20.05.2016.
 */
class PostToCreation{
    public var message:String  =""
        @JsonProperty(access = JsonProperty.Access.READ_WRITE)
        get
        set
    companion object{
        fun toPost(postToCreation: PostToCreation):Post{
            val post = Post()
            post.message = postToCreation.message
            post.creationDate = Date()
            return post
        }
    }
}