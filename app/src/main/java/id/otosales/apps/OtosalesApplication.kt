package id.otosales.apps

import android.app.Application
import id.otosales.apps.api.model.city.CityResponse
import id.otosales.apps.api.model.city.CityResponseData
import id.otosales.apps.api.model.province.ProvinceResponse
import id.otosales.apps.database.entity.EntityCity
import id.otosales.apps.database.entity.EntityProvince
import id.otosales.apps.helper.ApiHelper
import id.otosales.apps.helper.DatabaseHelper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import retrofit2.Response

class OtosalesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        this.setProvince()
        this.setCity()
    }

    private fun setProvince() {
        var provinces = ArrayList<CityResponseData>()
        CompositeDisposable().add(
            ApiHelper
                .getProvince()
                .subscribeWith(object : DisposableObserver<Response<ProvinceResponse>>() {
                    override fun onNext(t: Response<ProvinceResponse>) {
                        provinces = t.body()!!.data
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {
                        val daoProvince = DatabaseHelper.daoProvince(this@OtosalesApplication)

                        if (provinces.size != daoProvince.getAll().size){
                            for (i in provinces){
                                daoProvince.insert(EntityProvince(i.id, i.name))
                            }
                        }
                    }
                })
        )
    }

    private fun setCity() {
        var cities = ArrayList<CityResponseData>()
        CompositeDisposable().add(
            ApiHelper
                .getCity()
                .subscribeWith(object : DisposableObserver<Response<CityResponse>>() {
                    override fun onNext(t: Response<CityResponse>) {
                        cities = t.body()!!.data
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {
                        val daoCity = DatabaseHelper.daoCity(this@OtosalesApplication)
                        if (cities.size != daoCity.getAll().size){
                            for (i in cities){
                                daoCity.insert(EntityCity(i.id, i.provinceId, i.name))
                            }
                        }
                    }
                })
        )
    }
}