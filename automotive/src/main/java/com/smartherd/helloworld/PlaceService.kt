package com.smartherd.helloworld;

import android.content.Intent
import androidx.car.app.CarAppService
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.constraints.ConstraintManager
import androidx.car.app.model.*
import androidx.car.app.validation.HostValidator
import com.example.example.StationList
import com.google.gson.Gson

class PlaceService : CarAppService() {
    override fun createHostValidator(): HostValidator {
        return HostValidator.Builder(applicationContext)
            .addAllowedHosts(androidx.car.app.R.array.hosts_allowlist_sample)
            .build()
    }

    override fun onCreateSession(): Session {
        val json = resources.openRawResource(R.raw.fuel_stations).bufferedReader().use { it.readText() }
        val stations = Gson().fromJson(json, StationList::class.java)

//        val carLocationList = stations.stations.toList().map { CarLocation.create(it.latitude!!,it.longitude!!)  }

        return PlaceSession(stations)
    }
}




class PlaceSession(val stations: StationList) : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return PlaceScreen(carContext, stations)
    }
}

class PlaceScreen(carContext: CarContext, val stations: StationList) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val manager = carContext.getCarService(ConstraintManager::class.java)
        val rowItemLimit = manager.getContentLimit(ConstraintManager.CONTENT_LIMIT_TYPE_LIST)
        return placeTemplateBuilder(stations, rowItemLimit)
    }
}
//
//class Settings(carContext: CarContext) : Screen(carContext) {
//    override fun onGetTemplate(): Template {
//        val row = Row.Builder().setTitle("Hello World").build()
//        val pane = Pane.Builder().addRow(row).build()
//        return PaneTemplate.Builder(pane)
//            .setHeaderAction(Action.BACK)
//            .build()
//    }
//}

fun placeTemplateBuilder(stations: StationList, rowItemLimit: Int) : PlaceListMapTemplate {
//    val headerAction = Action.BACK

    val searchAction = Action.Builder().setTitle("Search").build()
//    val zoomInAction = Action.Builder().setTitle("Zoom In").build()
//    val zoomOutAction = Action.Builder().setTitle("Zoom out").build()


    val listStations = stations.stations.subList(0,rowItemLimit-1)



    val actionStrip = ActionStrip.Builder()
        .addAction(searchAction)
        .build()

    val itemListBuilder = ItemList.Builder()

    val placeList = listStations.map { Place.Builder(CarLocation.create(it.latitude ?:0.0 ,it.longitude?:0.0)).setMarker(PlaceMarker.Builder()
        .build()).build() }
//


    //adds rows for each list item of stations
    listStations.forEach{
        itemListBuilder.addItem(Row.Builder()
            .setBrowsable(true)
            .setOnClickListener { val a = 0 }
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
