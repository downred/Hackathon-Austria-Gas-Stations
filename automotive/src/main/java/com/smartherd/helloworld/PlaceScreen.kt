package com.smartherd.helloworld

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.ScreenManager
import androidx.car.app.constraints.ConstraintManager
import androidx.car.app.model.*

class PlaceScreen(carContext: CarContext, val stations: StationList) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val manager = carContext.getCarService(ConstraintManager::class.java)
        val rowItemLimit = manager.getContentLimit(ConstraintManager.CONTENT_LIMIT_TYPE_LIST)
        val screenManager = carContext.getCarService<ScreenManager>(ScreenManager::class.java)
        return placeTemplateBuilder(stations, rowItemLimit, screenManager)
    }

    fun placeTemplateBuilder(stations: StationList, rowItemLimit: Int, screenManager : ScreenManager) : PlaceListMapTemplate {
//    val headerAction = Action.BACK
//

        val listStations = stations.stations.subList(0,rowItemLimit-1)
        val titleList = listStations.map { it.title.toString() }

        val settingsAction = Action.Builder().setTitle("Settings").setOnClickListener{

            screenManager.push(SettingsScreen(carContext))
        }
            .build()
//        val searchAction = Action.Builder().setIcon(
//            CarIcon.Builder()
//        ).setOnClickListener {
//            screenManager.push(SearchScreen(carContext, titleList))
//        }.build()
//    val zoomInAction = Action.Builder().setTitle("Zoom In").build()
//    val zoomOutAction = Action.Builder().setTitle("Zoom out").build()



        val actionStrip = ActionStrip.Builder()
            .addAction(settingsAction)
            .build()

        val itemListBuilder = ItemList.Builder()

        val placeList = listStations.map { Place.Builder(
            CarLocation
            .create(it.latitude ?:0.0 ,it.longitude?:0.0))
            .setMarker(
                PlaceMarker.Builder()
                .build()).build() }
//


        //adds rows for each list item of stations
        listStations.forEach{
            itemListBuilder.addItem(
                Row.Builder()
                    .setBrowsable(true)
                    .setOnClickListener {
                        screenManager.push(DetailsScreen(carContext, it))
                    }
                    .setTitle(it.title.toString())
                    .build())
        }


        val itemList = itemListBuilder.build()

        return PlaceListMapTemplate.Builder()
            .setActionStrip(actionStrip)
//        .setHeaderAction(headerAction)
            .setItemList(itemList)
            .setAnchor(placeList[0])
            .setTitle("Fuel stations")
//            .setCurrentLocationEnabled(true)
            .build()
    }

}