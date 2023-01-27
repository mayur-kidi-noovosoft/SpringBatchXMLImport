package com.example.springbatchxmlimport.config

import com.example.springbatchxmlimport.EmployeeItemProcessor
import com.example.springbatchxmlimport.EmployeeItemWriter
import com.example.springbatchxmlimport.XmlItemReader
import com.example.springbatchxmlimport.model.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class BatchConfig {
    @Autowired
    private lateinit var itemReader: XmlItemReader

    @Autowired
    private lateinit var itemWriter: EmployeeItemWriter

    @Autowired
    private lateinit var employeeItemProcessor: EmployeeItemProcessor

    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Bean
    fun job(): Job {
        return jobBuilderFactory.get("importEmployeesJob")
                .incrementer(RunIdIncrementer())
                .flow(step1())
                .end()
                .build()
    }

    @Bean
    fun step1(): Step {
        return stepBuilderFactory.get("step1")
                .chunk<Employee, Employee>(10)
                .reader(itemReader)
                .processor(employeeItemProcessor)
                .writer(itemWriter)
                .build()
    }
}
