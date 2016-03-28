package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import org.hibernate.validator.constraints.Length
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Created by dominik on 22.03.16.
 */
@Entity
@Table(name = "Posts")
open class Post():Serializable{

    constructor(id:Int, message:String, rate: Int, author:User) : this(){
        this.id = id;
        this.message = message;
        this.rate = rate;
        this.author = author;
    }

    var id:Int = 0
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        get
        set

    var message:String = ""
        @Column
        get
        set

    var rate:Int = 0
        @Column
        get
        set

    var author:User = User()
    @NotNull
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    get
    set

    override fun toString(): String {
        return "[id=$id, message=$message, rate=$rate]";
    }
}