package id.otosales.apps.api.model.register

import com.google.gson.annotations.SerializedName
import id.otosales.apps.api.model.BaseResponse

data class RegisterRequest(
    @SerializedName("email") var email: String,
    @SerializedName("name") var name: String,
    @SerializedName("phone") var phone: String
)
