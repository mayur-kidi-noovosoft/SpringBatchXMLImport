package com.example.springbatchxmlimport.model

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement


@Entity
data class Employee(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        val firstName: String,
        val lastName: String,
        val email: String
)