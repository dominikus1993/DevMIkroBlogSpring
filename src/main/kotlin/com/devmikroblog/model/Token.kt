package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Created by dominik on 12.04.16.
 */
@Entity
@Table(name = "Tokens")
public class Token : Serializable {

    var id:Int = 0
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        get
        set

    private var tokenValue: String = ""
        @JsonIgnore
        @NotNull
        @Column(name = "token_value", nullable = false)
        get
        set

    private var tokenDate: LocalDate = LocalDate.now()
        @JsonIgnore
        @Column(name = "toke_date")
        get
        set

    private var user:User = User();
        @JsonIgnore
        @ManyToOne
        get
        set
}