package id.otosales.apps.dummy.article

import java.io.Serializable


data class Article(
    var id : Long?,
    var title : String?,
    var shortDescription : String?,
    var fullDescription : String?
)