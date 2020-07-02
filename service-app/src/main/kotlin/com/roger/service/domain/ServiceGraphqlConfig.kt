package com.roger.service.domain

import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import graphql.schema.DataFetchingEnvironment
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

val services = mutableMapOf<Long, Service>()

@Component
class ServiceQuery : Query {
    fun service(id: Long) = services[id]
}

@Component
class ServiceMutation : Mutation {
    fun service(service: ServiceInput): Service {
        services[service.id] = Service(service.id, service.productType, service.operatorCode)
        return services[service.id]!!
    }
}

val serviceResolver = object : FederatedTypeResolver<Service> {
    override suspend fun resolve(environment: DataFetchingEnvironment, representations: List<Map<String, Any>>): List<Service?> = representations.map {
        services[it["id"]]
    }
}

@Bean
fun federatedTypeRegistry() = FederatedTypeRegistry(mapOf("Service" to serviceResolver))
