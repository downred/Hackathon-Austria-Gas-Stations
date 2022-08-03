package com.smartherd.helloworld

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*

class DetailsScreen(carContext: CarContext, val details: Stations): Screen(carContext) {
    override fun onGetTemplate(): Template {
        val paneBuilder = Pane.Builder()

        val priceRow = Row.Builder()
            .setTitle(if (details.prices != null) "Fuel price:" + details.prices!!.superDiesel!!.price.toString() + " Euros." else "Unknown price").build()
        val fuelRow = Row.Builder()
            .setTitle(if (details.availableFuelTypes != null) "Fuel types: " + details.availableFuelTypes.joinToString(", ") else "Unknown fuel type").build()
        val paneTemplateBuilder = PaneTemplate.Builder(paneBuilder.addRow(fuelRow).addRow(priceRow).build())


        return paneTemplateBuilder
            .setTitle(details.title.toString())
            .setHeaderAction(Action.BACK)
            .build()
    }
}