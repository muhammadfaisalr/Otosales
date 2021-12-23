package id.otosales.apps.api.model.province

import com.google.gson.annotations.SerializedName
import id.otosales.apps.api.model.bank.BankResponseData

data class ProvinceResponseData(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
) {}