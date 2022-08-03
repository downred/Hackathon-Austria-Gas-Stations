package com.smartherd.helloworld;

import androidx.car.app.*
import androidx.car.app.model.*
import androidx.car.app.validation.HostValidator
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


