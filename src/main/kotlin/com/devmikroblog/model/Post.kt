package com.devmikroblog.model

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Created by dominik on 22.03.16.
 */
@Entity
@Table(name = "Posts")
open class Post():Serializable{

    constructor(id:Int, message:String, rate: Int, author:User, comments:List<Post>, tags:List<Tag>) : this(){
        this.id = id;
        this.message = message;
        this.rate = rate;
        this.author = author;
        this.comments = comments;
        this.tags = tags;
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
        get
        set

    var comments:List<Post> = listOf()
        @ManyToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinTable(name = "PostsComments",
            joinColumns = arrayOf(JoinColumn(name = "PostId")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "CommentsId")))
        get
        set

    var tags:List<Tag> = listOf()
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "PostsTags",
            joinColumns = arrayOf(JoinColumn(name = "PostId")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "TagId")))
        get
        set

    var votes:List<Vote> = listOf()
        @OneToMany(mappedBy = "post")
        get
        set

    override fun toString(): String {
        return "[id=$id, message=$message, rate=$rate]";
    }
}