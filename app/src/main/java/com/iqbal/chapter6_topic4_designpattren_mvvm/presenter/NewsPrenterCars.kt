package com.iqbal.chapter6_topic4_designpattren_mvvm.presenter

import com.iqbal.chapter6_topic4_designpattren_mvvm.model.GetDataResponCarsItem
import com.iqbal.chapter6_topic4_designpattren_mvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPrenterCars (val  viewCars : NewsCars) {

    fun getDatCars() {
        ApiClient.instance.getAllCars()
            .enqueue(object : Callback<List<GetDataResponCarsItem>>{
                override fun onResponse(
                    call: Call<List<GetDataResponCarsItem>>,
                    response: Response<List<GetDataResponCarsItem>>
                ) {
                    if (response.isSuccessful){
                        viewCars.onSuccess(response.message(),response.body()!!)
                    }else{
                        viewCars.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetDataResponCarsItem>>, t: Throwable) {
                    viewCars.onError(t.message!!)
                }

            })
    }
}