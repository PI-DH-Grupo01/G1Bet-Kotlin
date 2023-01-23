package br.com.g1bet

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object G1BetApiApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(G1BetApiApplication::class.java, args)
    }
}