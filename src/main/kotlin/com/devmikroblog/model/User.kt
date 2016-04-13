package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull


/**
 * Created by dominik on 28.03.16.
 */
@Entity
@Table(name = "Users")
public class User(): UserDetails, Serializable{

    @Transient
    override fun getPassword(): String? = userPassword

    @Transient
    override fun getUsername(): String? = login

    @Transient
    override fun isCredentialsNonExpired(): Boolean = true

    @Transient
    override fun isAccountNonExpired(): Boolean = true

    @Transient
    override fun isAccountNonLocked(): Boolean = true

    @Transient
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
       return AuthorityUtils.createAuthorityList(role.role)
    }

    @Transient
    override fun isEnabled(): Boolean = activated

    constructor(id:Int, login:String, userPassword:String, posts:List<Post>, role: Role, persistentTokens:List<Token>) : this(){
        this.id = id;
        this.login = login;
        this.userPassword = userPassword;
        this.posts = posts;
        this.role = role;
        this.persistentTokens = persistentTokens;
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

    var persistentTokens:List<Token> = listOf()
        @JsonIgnore
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        get
        set

    override fun toString(): String {
        return "[id=$id, username=$login, password=$userPassword]";
    }
}