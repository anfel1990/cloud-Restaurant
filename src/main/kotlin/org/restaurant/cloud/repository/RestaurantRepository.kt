package org.restaurant.cloud.repository

import com.fasterxml.jackson.databind.ObjectMapper
import org.restaurant.cloud.entity.Restaurant
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class RestaurantRepository {

    lateinit var fluxRestaurant: Flux<Restaurant>

    init {
        val array = ObjectMapper().readValue(javaClass.getResource("/data/restaurants.json"), Array<Restaurant>::class.java)
        fluxRestaurant = Flux.fromArray(array)
    }


    fun updateRestaurant(restaurant: Restaurant) = fluxRestaurant.map { if(it.libelle.equals(restaurant.libelle, true)) it.listRates.add(restaurant.rate); it.updateRate(); it }

    fun getRestaurantsFlux() = fluxRestaurant
}