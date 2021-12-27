package id.otosales.apps.api.model.brand

import com.google.gson.annotations.SerializedName

open  class BrandResponseDetail(
   @SerializedName("id") var id: Int,
   @SerializedName("name") var name: String,
   @SerializedName("logoUrl") var logoUrl: String,
   @SerializedName("categoryId") var categoryId: Int,
   @SerializedName("categoryName") var categoryName: String
) {}