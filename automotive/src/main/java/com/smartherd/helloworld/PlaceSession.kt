package com.smartherd.helloworld

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.ScreenManager
import androidx.car.app.Session
import androidx.car.app.model.*

class PlaceSession(val stations: StationList) : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return PlaceScreen(carContext, stations)
    }
}
