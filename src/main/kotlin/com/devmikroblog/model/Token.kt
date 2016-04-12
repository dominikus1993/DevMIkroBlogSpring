package com.devmikroblog.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

/**
 * Created by dominik on 12.04.16.
 */
public class Token : Serializable {
    private var series: String = ""
        @Id
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