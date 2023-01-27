package com.example.springbatchxmlimport

import com.example.springbatchxmlimport.model.Employee
import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class EmployeeItemProcessor : ItemProcessor<Employee, Employee> {

    override fun process(employee: Employee): Employee {
        return employee
    }
}
