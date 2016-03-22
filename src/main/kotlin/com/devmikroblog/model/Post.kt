package com.devmikroblog.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by dominik on 22.03.16.
 */
open class Post():Serializable{

    constructor(id:Int, message:String, rate: Int) : this(){
        this.id = id;
        this.message = message;
        this.rate = rate;
    }

    public var id:Int = 0
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    get

    public var message:String = ""
    @Column
    get

    public var rate:Int = 0
    @Column
    get

    override fun toString(): String {
        return "[id=$id, message=$message, rate=$rate]";
    }



}