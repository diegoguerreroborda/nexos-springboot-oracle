package com.dhgb.testSpringbootOracle.springbootOracle.repository

import com.dhgb.testSpringbootOracle.springbootOracle.dto.UserRequest
import com.dhgb.testSpringbootOracle.springbootOracle.database.UserDb
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.security.crypto.bcrypt.BCrypt
import java.sql.ResultSet

class UserRepository(private val jdbcTemplate: JdbcTemplate) {

    fun findAllIntoDb(): List<UserDb> {
        val rowMapper: RowMapper<UserDb> = getMapperUserToOracle()
        return jdbcTemplate.query("SELECT * FROM $TABLE_NAME", rowMapper)
    }

    fun findColumnIntoDb(column: String): List<String> {
        val rowMapper = getMapperUserColumnToOracle(column)
        return jdbcTemplate.query("SELECT $column FROM $TABLE_NAME", rowMapper)
    }

    fun addUserDb(user: UserRequest): Boolean {
        return try {
            val encrypted: String = BCrypt.hashpw(user.password, BCrypt.gensalt())
            jdbcTemplate.update("INSERT INTO $TABLE_NAME (id, name, password, phone) " +
                    "VALUES (?, ?, ?, ?)", user.id, user.userName, encrypted, user.phone)
            true
        }catch (e: Exception){
            false
        }
    }

    fun deleteUserById(id: Int): Boolean {
        return jdbcTemplate.update("DELETE FROM $TABLE_NAME WHERE id = $id") == 1
    }

    private fun getMapperUserToOracle(): RowMapper<UserDb> {
        return RowMapper<UserDb> { resultSet: ResultSet, index: Int ->
            UserDb(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("phone")
            )
        }
    }

    private fun getMapperUserColumnToOracle(column: String): RowMapper<String> {
        return RowMapper<String> { resultSet: ResultSet, index: Int ->
                    resultSet.getString(column)
        }
    }

    companion object {
        private const val TABLE_NAME = "user1"
    }
}