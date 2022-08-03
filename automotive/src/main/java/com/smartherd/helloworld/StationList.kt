package com.smartherd.helloworld

import com.google.gson.annotations.SerializedName


data class StationList (

  @SerializedName("stations" )
  var stations: List<Stations>

)