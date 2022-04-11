package com.dhgb.testSpringbootOracle.springbootOracle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestSpringbootApplication

fun main(args: Array<String>) {
	runApplication<TestSpringbootApplication>(*args)
}