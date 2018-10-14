package org.restaurant.cloud.entity

data class Restaurant(var libelle: String = "",
                      var rate: Double = 0.toDouble(),
                      var listRates: MutableList<Double> = mutableListOf()) {

    fun updateRate() {
        rate = when(listRates.isEmpty()) {
            false -> listRates.average()
            else  -> 0.0
        }
    }
}