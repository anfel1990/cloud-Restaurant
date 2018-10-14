package org.restaurant.cloud.service

import org.restaurant.cloud.entity.Restaurant
import org.restaurant.cloud.repository.RestaurantRepository
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Service
class RestaurantService(val restaurantRepository: RestaurantRepository) {

    fun findAll(request: ServerRequest) = ok().render("index", mapOf("restaurants" to restaurantRepository.getRestaurantsFlux()))

    fun updateRate(request: ServerRequest) = request.bodyToMono(Restaurant::class.java)
                                                    .flatMap { ok().render("index", mapOf("restaurants" to restaurantRepository.updateRestaurant(it).log())) }
}