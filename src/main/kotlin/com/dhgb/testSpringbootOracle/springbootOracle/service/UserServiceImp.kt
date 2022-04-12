package com.dhgb.testSpringbootOracle.springbootOracle.service

import com.dhgb.testSpringbootOracle.springbootOracle.model.User
import com.dhgb.testSpringbootOracle.springbootOracle.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImp: UserService {

    @Autowired
    lateinit var userRepo: UserRepo

    override fun findAllUsers(): List<User> {
        return userRepo.findAll()
    }

    override fun findUsersByName(name: String): List<User> {
        return userRepo.findAll()
    }

    override fun saveUser(user: User): Boolean {
        return try {
            userRepo.save(user)
            true
        }catch (e: Exception){
            false
        }
    }

    override fun deleteUser(id: Int): Boolean {
        return try {
//            println("Encontrado: ${userRepo.findById(id).get()}")
            if(!userRepo.findById(id).isEmpty){
                println("Entraaa")
                userRepo.delete(userRepo.findById(id).get())
            }
            true
        }catch (e: Exception){
            false
        }
    }

    override fun updateUser(id: Int): Boolean {
        return try {
//            userRepo.updateUser(id)
            true
        }catch (e: Exception){
            false
        }
    }
}