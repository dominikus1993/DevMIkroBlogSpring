package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull


/**
 * Created by dominik on 28.03.16.
 */
@Entity
@Table(name = "Users")
public class User(): UserDetails {

    override fun getPassword(): String? = userPassword

    override fun getUsername(): String? = login


    override fun isCredentialsNonExpired(): Boolean = true

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        throw UnsupportedOperationException()
    }

    override fun isEnabled(): Boolean = activated

    constructor(id:Int, login:String, userPassword:String, posts:List<Post>, role: Role) : this(){
        this.id = id;
        this.login = login;
        this.userPassword = userPassword;
        this.posts = posts;
        this.role = role;
    }

    var id:Int = 0
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        get
        set

    var login:String = ""
        @NotNull
        @Column(unique = true)
        get
        set

    var userPassword:String = ""
        @NotNull
        get
        set

    var activated = false
        @NotNull
        @Column(nullable = false)
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
        set

    var persistentTokens:Set<Token> = setOf()
        @JsonIgnore
        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true, mappedBy = "user")

    override fun toString(): String {
        return "[id=$id, username=$login, password=$userPassword]";
    }
}