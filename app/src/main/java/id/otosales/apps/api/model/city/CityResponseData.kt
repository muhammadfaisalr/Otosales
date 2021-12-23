package id.otosales.apps.api.model.city

import com.google.gson.annotations.SerializedName

data class CityResponseData(
    @SerializedName("id") var id: Int,
    @SerializedName("provinceId") var provinceId: Int,
    @SerializedName("name") var name: String,
) {}