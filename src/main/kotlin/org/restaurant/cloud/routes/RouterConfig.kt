package org.restaurant.cloud.routes

import org.restaurant.cloud.service.RestaurantService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class RouterConfig(val restaurantService: RestaurantService) {

    @Bean
    fun restaurantRoutes() = router {
        GET("/", restaurantService::findAll)
        POST("/rate", restaurantService::updateRate)
    }
}