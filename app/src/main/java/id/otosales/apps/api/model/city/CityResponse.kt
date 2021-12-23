package id.otosales.apps.api.model.city

import com.google.gson.annotations.SerializedName
import id.otosales.apps.api.model.city.CityResponseData

data class CityResponse(

    @SerializedName("code") var code: Int,
    @SerializedName("status") var status: String,
    @SerializedName("message") var message: String,
    @SerializedName("data") var data: ArrayList<CityResponseData>
) {
}