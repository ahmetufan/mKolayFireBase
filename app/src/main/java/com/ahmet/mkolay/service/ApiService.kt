package com.ahmet.mkolay.service

import com.ahmet.mkolay.models.ServiceModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    //   http://www.adddisyon.online/  mkolayget.php

    @GET("mkolayget.php")
    fun sepetAPI(): Single<List<ServiceModel>>


}