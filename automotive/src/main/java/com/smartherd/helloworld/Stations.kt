package com.smartherd.helloworld

import com.google.gson.annotations.SerializedName


data class Stations (

  @SerializedName("id"                   ) var id                 : String?           = null,
  @SerializedName("timestamp"            ) var timestamp          : String?           = null,
  @SerializedName("title"                ) var title              : String?           = null,
  @SerializedName("longitude"            ) var longitude          : Double?           = null,
  @SerializedName("latitude"             ) var latitude           : Double?           = null,
  @SerializedName("addr_zip"             ) var addrZip            : String?           = null,
  @SerializedName("addr_city"            ) var addrCity           : String?           = null,
  @SerializedName("addr_street"          ) var addrStreet         : String?           = null,
  @SerializedName("addr_hnr"             ) var addrHnr            : String?           = null,
  @SerializedName("addr_street_hnr"      ) var addrStreetHnr      : String?           = null,
  @SerializedName("phone"                ) var phone              : String?           = null,
  @SerializedName("email"                ) var email              : String?           = null,
  @SerializedName("website"              ) var website            : String?           = null,
  @SerializedName("opening_hours"        ) var openingHours       : String?           = null,
  @SerializedName("available_fuel_types" ) var availableFuelTypes : List<String> = listOf(),
  @SerializedName("plugs"                ) var plugs              : ArrayList<Plugs>  = arrayListOf(),
  @SerializedName("is_partner"           ) var isPartner          : Boolean?          = null,
  @SerializedName("prices"               ) var prices             : Prices?           = Prices()

)

data class Fuels(
  var diesel: Boolean, var energy : Boolean
)

data class Diesel (

  @SerializedName("price"            ) var price            : Double? = null,
  @SerializedName("report_timestamp" ) var reportTimestamp  : Int?    = null,
  @SerializedName("source"           ) var source           : String? = null,
  @SerializedName("displayTimestamp" ) var displayTimestamp : String? = null

)

data class Plugs (

  @SerializedName("type"    ) var type    : Int? = null,
  @SerializedName("voltage" ) var voltage : Int? = null,
  @SerializedName("current" ) var current : Int? = null

)

data class Prices (

  @SerializedName("diesel" ) var diesel : Diesel? = Diesel(),
  @SerializedName("super"  ) var superDiesel  : Super?  = Super()

)

data class Super (

  @SerializedName("price"            ) var price            : Double? = null,
  @SerializedName("report_timestamp" ) var reportTimestamp  : Int?    = null,
  @SerializedName("source"           ) var source           : String? = null,
  @SerializedName("displayTimestamp" ) var displayTimestamp : String? = null

)

data class StationList (

  @SerializedName("stations" )
  var stations: List<Stations>

)