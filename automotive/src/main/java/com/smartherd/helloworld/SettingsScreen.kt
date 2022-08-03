package com.smartherd.helloworld

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*

class SettingsScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        var diesel = true
        var energy = true
        val listTemplateBuilder = ListTemplate.Builder()
        val rowHelpfulHint = Row.Builder().setTitle("Fuel types").addText("Which ones do you want to see").build()
        val rowDiesel = Row.Builder()
            .setTitle("Diesel")
            .setToggle(
                Toggle.Builder(Toggle.OnCheckedChangeListener { diesel = it })
                    .setChecked(true)
                    .build()
            ).build()
        val rowEnergy = Row.Builder()
            .setTitle("Energy")
            .setToggle(
                Toggle.Builder(Toggle.OnCheckedChangeListener { energy = it })
                    .setChecked(true)
                    .build()
            ).build()
        val headerAction = Action.BACK

        val itemList = ItemList.Builder().addItem(rowHelpfulHint).addItem(rowDiesel).addItem(rowEnergy).build()

        return listTemplateBuilder.setHeaderAction(headerAction)
            .addSectionedList(SectionedItemList.create(itemList,"Settings")).build()
    }
}
