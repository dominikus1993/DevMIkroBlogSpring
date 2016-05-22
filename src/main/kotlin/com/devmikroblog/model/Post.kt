package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Created by dominik on 22.03.16.
 */
@Entity
@Table(name = "Posts")
class Post():Serializable{

    constructor(id:Int, message:String, rate: Int, author:User, creationDate: Date, comments:Set<Post>, tags:Set<Tag>) : this(){
        this.id = id;
        this.message = message;
        this.rate = rate;
        this.author = author;
        this.comments = comments;
        this.tags = tags;
        this.creationDate = creationDate;
    }

    var id:Int = 0
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        get
        set

    var message:String = ""
        @Column
        @JsonProperty(access = JsonProperty.Access.READ_WRITE)
        get
        set

    var creationDate: Date = Date()
        @NotNull
        @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
        @JsonFormat(pattern = "HH:mm dd-MM-yyyy")
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var rate:Int = 0
        @Column
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var author:User = User()
        @NotNull
        @ManyToOne
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var comments:Set<Post> = setOf()
        @ManyToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        @JoinTable(name = "PostsComments",
            joinColumns = arrayOf(JoinColumn(name = "PostId")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "CommentsId")))
        @LazyCollection(LazyCollectionOption.FALSE)
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var tags:Set<Tag> = setOf()
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "PostsTags",
            joinColumns = arrayOf(JoinColumn(name = "PostId")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "TagId")))
        @LazyCollection(LazyCollectionOption.FALSE)
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var votes:Set<Vote> = setOf()
        @OneToMany(mappedBy = "post")
        @LazyCollection(LazyCollectionOption.FALSE)
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    override fun toString(): String {
        return "[id=$id, message=$message, rate=$rate]";
    }
}