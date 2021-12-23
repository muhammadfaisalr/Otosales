package id.otosales.apps.api.model.article

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ArticleResponseData(
    @SerializedName("id") var id: Long,
    @SerializedName("title") var title: String,
    @SerializedName("content") var content: String,
    @SerializedName("created") var created: String,
    @SerializedName("creator") var creator: String,
    @SerializedName("tags") var tags: String,
    @SerializedName("likes") var likes: Int,
    @SerializedName("images") var images: String,
) : Serializable