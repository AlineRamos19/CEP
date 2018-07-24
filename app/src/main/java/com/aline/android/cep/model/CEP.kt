package com.aline.android.cep.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CEP {

    @SerializedName("cep")
    @Expose
    var cep: String? = null
    @SerializedName("address_type")
    @Expose
    var addressType: String? = null
    @SerializedName("address_name")
    @Expose
    var addressName: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("district")
    @Expose
    var district: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("lat")
    @Expose
    var lat: String? = null
    @SerializedName("lng")
    @Expose
    var lng: String? = null
    @SerializedName("ddd")
    @Expose
    var ddd: String? = null
    @SerializedName("city_ibge")
    @Expose
    var cityIbge: String? = null

}
