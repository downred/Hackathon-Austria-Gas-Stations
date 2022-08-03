package com.smartherd.helloworld

import com.google.gson.annotations.SerializedName


data class Plugs (

  @SerializedName("type"    ) var type    : Int? = null,
  @SerializedName("voltage" ) var voltage : Int? = null,
  @SerializedName("current" ) var current : Int? = null

)