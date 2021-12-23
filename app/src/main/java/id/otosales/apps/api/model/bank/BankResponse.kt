package id.otosales.apps.api.model.bank

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

open class BankResponse (
    @SerializedName("code") var code: Int,
    @SerializedName("status") var status: String,
    @SerializedName("message") var message: String,
    @SerializedName("data") var data: ArrayList<BankResponseData>?
)