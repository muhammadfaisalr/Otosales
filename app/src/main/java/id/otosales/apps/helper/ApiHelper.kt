package id.otosales.apps.helper

import id.otosales.apps.api.ApiServices
import id.otosales.apps.api.model.BaseResponse
import id.otosales.apps.api.model.article.ArticleResponse
import id.otosales.apps.api.model.bank.BankResponse
import id.otosales.apps.api.model.brand.BrandResponse
import id.otosales.apps.api.model.city.CityResponse
import id.otosales.apps.api.model.province.ProvinceResponse
import id.otosales.apps.api.model.register.RegisterRequest
import id.otosales.apps.api.tools.RetrofitBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class ApiHelper {
    companion object {
        private fun getServices(): ApiServices {
            return RetrofitBuilder.getRetrofit().create(ApiServices::class.java)
        }

        fun hitRegister(registerRequest: RegisterRequest): Observable<Response<BaseResponse>> {
            return getServices()
                .register(registerRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        }

        fun getBanks(): Observable<Response<BankResponse>> {
            return getServices()
                .bank()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        }

        fun getProvince(): Observable<Response<ProvinceResponse>> {
            return getServices()
                .province()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        }

        fun getCity(): Observable<Response<CityResponse>> {
            return getServices()
                .city()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        }

        fun getArticle(): Observable<Response<ArticleResponse>> {
            return getServices()
                .article()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        }

        fun getBrand(): Observable<Response<BrandResponse>> {
            return getServices()
                .brand()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        }
    }
}