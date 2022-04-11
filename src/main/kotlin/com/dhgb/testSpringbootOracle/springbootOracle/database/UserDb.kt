package com.dhgb.testSpringbootOracle.springbootOracle.database

data class UserDb(
        val id: String,
        val userName: String,
        val password: String,
        val phone: String?
)