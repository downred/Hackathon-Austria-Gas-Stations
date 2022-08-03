package com.smartherd.helloworld

import com.google.gson.annotations.SerializedName


data class Diesel (

  @SerializedName("price"            ) var price            : Double? = null,
  @SerializedName("report_timestamp" ) var reportTimestamp  : Int?    = null,
  @SerializedName("source"           ) var source           : String? = null,
  @SerializedName("displayTimestamp" ) var displayTimestamp : String? = null

)