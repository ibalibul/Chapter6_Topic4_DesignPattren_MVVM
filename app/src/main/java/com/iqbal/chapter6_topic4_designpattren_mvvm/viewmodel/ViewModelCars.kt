package com.iqbal.chapter6_topic4_designpattren_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbal.chapter6_topic4_designpattren_mvvm.model.GetDataResponCarsItem
import com.iqbal.chapter6_topic4_designpattren_mvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCars : ViewModel() {

    lateinit var liveDataCars : MutableLiveData<List<GetDataResponCarsItem>>

    init {
        liveDataCars =  MutableLiveData()
    }

    fun getLivedataCars() : MutableLiveData<List<GetDataResponCarsItem>>{
      return  liveDataCars
    }

    fun callApiCars() {
        ApiClient.instance.getAllCars()
            .enqueue(object : Callback<List<GetDataResponCarsItem>>{
                override fun onResponse(
                    call: Call<List<GetDataResponCarsItem>>,
                    response: Response<List<GetDataResponCarsItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCars.postValue(response.body())
                    }else{
                        liveDataCars.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetDataResponCarsItem>>, t: Throwable) {
                    liveDataCars.postValue(null)
                }

            })
    }

}