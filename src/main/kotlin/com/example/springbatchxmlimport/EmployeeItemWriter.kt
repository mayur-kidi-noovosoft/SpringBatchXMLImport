package com.example.springbatchxmlimport

import com.example.springbatchxmlimport.model.Employee
import com.example.springbatchxmlimport.repository.EmployeeRepository
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EmployeeItemWriter : ItemWriter<Employee> {
    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    override fun write(items: List<Employee>) {
        employeeRepository.saveAll(items)
    }
}
