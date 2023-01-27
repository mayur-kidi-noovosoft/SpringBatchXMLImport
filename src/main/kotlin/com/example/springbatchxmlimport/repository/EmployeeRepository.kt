package com.example.springbatchxmlimport.repository

import com.example.springbatchxmlimport.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long>