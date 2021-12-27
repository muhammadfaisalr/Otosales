package id.otosales.apps.api.model.brand

import com.google.gson.annotations.SerializedName

open class BrandResponse(
   @SerializedName("code") var code: Int,
   @SerializedName("status") var status: String,
   @SerializedName("message") var message: String,
   @SerializedName("data") var data: ArrayList<BrandResponseDetail>?
) {}