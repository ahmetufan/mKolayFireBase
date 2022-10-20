package com.ahmet.mkolay.service

import com.ahmet.mkolay.models.ServiceModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ApiServiceRepository @Inject constructor(private val apiservice:ApiService) {


    fun getSepetAPI(): Single<List<ServiceModel>> {
        return apiservice.sepetAPI()
    }


}