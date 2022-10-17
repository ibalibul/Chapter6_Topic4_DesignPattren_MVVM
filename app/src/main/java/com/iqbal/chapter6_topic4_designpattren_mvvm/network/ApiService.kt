package com.iqbal.chapter6_topic4_designpattren_mvvm.network

import com.iqbal.chapter6_topic4_designpattren_mvvm.model.GetDataResponCarsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCars() :Call<List<GetDataResponCarsItem>>
}