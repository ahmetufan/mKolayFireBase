package com.ahmet.mkolay.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmet.mkolay.models.ServiceModel
import com.ahmet.mkolay.service.ApiServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor(private val repository: ApiServiceRepository): ViewModel() {

    private val compositDisposabe=CompositeDisposable()

    val sepetLiveData=MutableLiveData<List<ServiceModel>>()

    fun getLiveData() {
        getDataFromAPI()
    }

    private fun getDataFromAPI() {

        compositDisposabe.add(repository.getSepetAPI()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableSingleObserver<List<ServiceModel>>() {
                override fun onSuccess(t: List<ServiceModel>) {
                    sepetLiveData.value=t
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            }))
    }

    override fun onCleared() {
        super.onCleared()
        compositDisposabe.clear()
    }

}