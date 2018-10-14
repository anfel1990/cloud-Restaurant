package org.restaurant.cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestaurantCloudApplication

fun main(args: Array<String>) {
    runApplication<RestaurantCloudApplication>(*args)
}
