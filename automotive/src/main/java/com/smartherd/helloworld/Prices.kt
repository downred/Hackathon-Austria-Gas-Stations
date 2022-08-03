package com.smartherd.helloworld

import com.google.gson.annotations.SerializedName


data class Prices (

  @SerializedName("diesel" ) var diesel : Diesel? = Diesel(),
  @SerializedName("super"  ) var superDiesel  : Super?  = Super()

)