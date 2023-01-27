package com.example.springbatchxmlimport.controller

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecutionException
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RestController
@RequestMapping("/batch")
class BatchController {

    @Autowired
    private lateinit var jobLauncher: JobLauncher
    @Autowired
    private lateinit var job: Job

    @PostMapping("/run")
    fun runBatchJob(): String {
        val jobParameters = JobParametersBuilder()
                .addDate("runDate", Date())
                .toJobParameters()
        return try {
            jobLauncher.run(job, jobParameters)
            "Batch job has been run successfully!"
        } catch (e: JobExecutionException) {
            "Error running batch job: " + e.message
        }
    }
}