package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull


/**
 * Created by dominik on 28.03.16.
 */
@Entity
@Table(name = "Users")
open class User(): Serializable {
    constructor(id:Int, username:String, password:String, posts:List<Post>, role: Role) : this(){
        this.id = id;
        this.username = username;
        this.password = password;
        this.posts = posts;
        this.role = role;
    }

    var id:Int = 0
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        get
        set

    var username:String = ""
        @NotNull
        @Column(unique = true)
        get
        set

    var password:String = ""
        @NotNull
        get
        set

    var posts:List<Post> = listOf()
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @LazyCollection(LazyCollectionOption.FALSE)
        get
        set

    var role:Role = Role.USER
        @NotNull
        get

    override fun toString(): String {
        return "[id=$id, username=$username, password=$password]";
    }
}