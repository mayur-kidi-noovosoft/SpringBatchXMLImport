package com.example.springbatchxmlimport

import com.example.springbatchxmlimport.model.Employee
import org.springframework.batch.item.ItemReader
import org.springframework.core.io.Resource

import org.springframework.stereotype.Component
import javax.xml.bind.Unmarshaller
import javax.xml.transform.stream.StreamSource

@Component
class XmlItemReader() : ItemReader<Employee> {
    private lateinit var resource: Resource
    private lateinit var unmarshaller: Unmarshaller

    override fun read(): Employee? {
        val file = resource.file
         return unmarshaller.unmarshal(StreamSource(file)) as Employee
    }
}
