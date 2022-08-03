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
  @SerializedName("available_fuel_types" ) var availableFuelTypes : ArrayList<String> = arrayListOf(),
  @SerializedName("plugs"                ) var plugs              : ArrayList<Plugs>  = arrayListOf(),
  @SerializedName("is_partner"           ) var isPartner          : Boolean?          = null,
  @SerializedName("prices"               ) var prices             : Prices?           = Prices()

)