package com.roger.service.domain

import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

val services = mutableMapOf<Long, Service>()

@Component
class ServiceQuery : Query {
    fun service(id: Long) = services[id]
}

@Component
class ServiceMutation : Mutation {
    fun service(service: Service): Service {
        services[service.id] = service
        return services[service.id]!!
    }
}
