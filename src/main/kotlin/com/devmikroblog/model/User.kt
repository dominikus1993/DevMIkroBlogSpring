package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull


/**
 * Created by dominik on 28.03.16.
 */
@Entity
@Table(name = "Users")
public class User(): UserDetails, Serializable{

    @Transient
    @JsonIgnore
    override fun getPassword(): String? = userPassword

    @Transient
    @JsonIgnore
    override fun getUsername(): String? = login

    @Transient
    @JsonIgnore
    override fun isCredentialsNonExpired(): Boolean = true

    @Transient
    @JsonIgnore
    override fun isAccountNonExpired(): Boolean = true

    @Transient
    @JsonIgnore
    override fun isAccountNonLocked(): Boolean = true

    @Transient
    @JsonIgnore
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
       return AuthorityUtils.createAuthorityList(role.role)
    }

    @Transient
    @JsonIgnore
    override fun isEnabled(): Boolean = activated

    constructor(id:Int, login:String, userPassword:String, posts:Set<Post>, creationDate : Date, role: Role, persistentTokens:Set<Token>) : this(){
        this.id = id;
        this.login = login;
        this.userPassword = userPassword;
        this.posts = posts;
        this.role = role;
        this.persistentTokens = persistentTokens;
        this.creationDate = creationDate;
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
        @JsonIgnore
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
        @LazyCollection(LazyCollectionOption.TRUE)
        @JsonIgnore
        get
        set

    var creationDate: Date = Date()
        @NotNull
        @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
        @JsonFormat(pattern = "HH:mm dd-MM-yyyy")
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var role:Role = Role.USER
        @NotNull
        @Enumerated(EnumType.STRING)
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        get
        set

    var persistentTokens:Set<Token> = setOf()
        @JsonIgnore
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        get
        set

    override fun toString(): String {
        return "[id=$id, username=$login, password=$userPassword]";
    }
}