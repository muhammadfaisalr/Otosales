package id.otosales.apps.api.model.article

import com.google.gson.annotations.SerializedName

open class ArticleResponse (
    @SerializedName("code") var code: Int,
    @SerializedName("status") var status: String,
    @SerializedName("message") var message: String,
    @SerializedName("data") var data: ArrayList<ArticleResponseData>
)