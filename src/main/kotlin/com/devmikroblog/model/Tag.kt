package com.devmikroblog.model

import javax.persistence.*

/**
 * Created by dominik on 28.03.16.
 */
@Entity
@Table(name = "Tags")
class Tag(){

    constructor(id: Int, name:String):this(){
        this.id = id;
        this.name = name;
    }

    var id:Int = 0
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    get
    set

    var name:String = ""
    @Column
    get
    set

}