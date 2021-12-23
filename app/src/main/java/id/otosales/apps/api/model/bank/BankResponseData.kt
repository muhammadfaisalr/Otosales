package id.otosales.apps.api.model.bank

import com.google.gson.annotations.SerializedName

data class BankResponseData(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("shortName") var shortName: String,
    @SerializedName("bankCode") var bankCode: String,
    @SerializedName("accountNumber") var accountNumber: String,
) {}