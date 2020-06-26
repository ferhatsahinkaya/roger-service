package com.roger.service.domain

import com.expediagroup.graphql.SchemaGeneratorConfig
import com.expediagroup.graphql.TopLevelObject
import com.expediagroup.graphql.spring.operations.Query
import com.expediagroup.graphql.toSchema
import org.springframework.stereotype.Component

@Component
class ServiceQuery : Query {
    fun service(id: Long): Service {
        return Service(id)
    }
}

// Generate the schema
val config = SchemaGeneratorConfig(supportedPackages = listOf("com.roger.service.domain"))
val queries = listOf(TopLevelObject(ServiceQuery()))
val schema = toSchema(config, queries)