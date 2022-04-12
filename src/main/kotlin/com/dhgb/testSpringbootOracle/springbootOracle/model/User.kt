package com.dhgb.testSpringbootOracle.springbootOracle.model

import javax.persistence.*

@Entity
@Table(name = "USER_DB")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int = -1,
        @Column(name = "name", length = 50)
        val userName: String,
        @Column(name = "password", length = 200)
        val password: String,
        @Column(name = "phone", length = 15)
        val phone: String?,
){
        private constructor(): this(0, "", "", "")
}