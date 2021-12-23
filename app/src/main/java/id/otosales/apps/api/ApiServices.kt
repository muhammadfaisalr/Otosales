package id.otosales.apps.api

import id.otosales.apps.Constant
import id.otosales.apps.api.model.BaseResponse
import id.otosales.apps.api.model.article.ArticleResponse
import id.otosales.apps.api.model.bank.BankResponse
import id.otosales.apps.api.model.city.CityResponse
import id.otosales.apps.api.model.province.ProvinceResponse
import id.otosales.apps.api.model.register.RegisterRequest
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {
    @POST(Constant.Url.REGISTER)
    fun register(@Body registerRequest: RegisterRequest): Observable<Response<BaseResponse>>

    @GET(Constant.Url.BANK)
    fun bank(): Observable<Response<BankResponse>>

    @GET(Constant.Url.PROVINCE)
    fun province(): Observable<Response<ProvinceResponse>>

    @GET(Constant.Url.CITY)
    fun city(): Observable<Response<CityResponse>>

    @GET(Constant.Url.ARTICLE)
    fun article(): Observable<Response<ArticleResponse>>
}