package com.roger.service.domain

import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@KeyDirective(fields = FieldSet("id operatorCode"))
data class Service(val id: Long,
                   val productType: String,
                   val operatorCode: String)

// Needs to be different than Service class due to https://github.com/ExpediaGroup/graphql-kotlin/issues/363
data class ServiceInput(val id: Long,
                        val productType: String,
                        val operatorCode: String)