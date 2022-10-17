package com.iqbal.chapter6_topic4_designpattren_mvvm.presenter

import com.iqbal.chapter6_topic4_designpattren_mvvm.model.GetDataResponCarsItem

interface NewsCars {

    fun onSuccess(pesan : String, News : List<GetDataResponCarsItem>)
    fun onError(pesan: String)
}