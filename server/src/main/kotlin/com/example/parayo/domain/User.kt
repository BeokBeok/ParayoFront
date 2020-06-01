package com.example.parayo.domain

import java.util.*
import javax.persistence.*

@Entity(name = "user")
class User(
    val email: String,
    val password: String,
    val name: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var createdAt: Date = Date(0)
    var updatedAt: Date = Date(0)

    @PrePersist // DB 에 새 데이터가 저장되기 전에 자동으로 호출
    fun prePersist() {
        createdAt = Date()
        updatedAt = Date()
    }

    @PreUpdate // DB 에 데이터를 업데이트 하기 전에 호출
    fun preUpdate() {
        updatedAt = Date()
    }
}