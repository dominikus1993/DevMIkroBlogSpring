package com.devmikroblog.model

import javax.persistence.*

/**
 * Created by dominik on 28.03.16.
 */
@Entity
@Table(name = "Votes")
class Vote() {
    constructor(id:Int):this(){
        this.id = id;
    }

    var id:Int = 0
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        get
        set

    var voteType:VoteType = VoteType.VoteUp
        @Column
        get
        set

    var post:Post = Post()
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "PostId", nullable = false)
        get
        set

    var user:User = User()
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "UserId", nullable = false)
        get
        set
}