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

    constructor(id:Int, login:String, userPassword:String, posts:Set<Post>, role: Role, persistentTokens:Set<Token>) : this(){
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
        @JsonProperty(access = JsonProperty.Access.READ_WRITE)
        get
        set

    var userPassword:String = ""
        @NotNull
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        get
        set

    var activated = false
        @NotNull
        @Column(nullable = false)
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var posts:Set<Post> = setOf()
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @LazyCollection(LazyCollectionOption.FALSE)
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var role:Role = Role.USER
        @NotNull
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var persistentTokens:Set<Token> = setOf()
        @JsonIgnore
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        get
        set

    override fun toString(): String {
        return "[id=$id, username=$login, password=$userPassword]";
    }
}