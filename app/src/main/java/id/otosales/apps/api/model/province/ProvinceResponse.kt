package id.otosales.apps.api.model.province

import com.google.gson.annotations.SerializedName
import id.otosales.apps.api.model.city.CityResponseData

data class ProvinceResponse(

    @SerializedName("code") var code: Int,
    @SerializedName("status") var status: String,
    @SerializedName("message") var message: String,
    @SerializedName("data") var data: ArrayList<CityResponseData>
) {
}