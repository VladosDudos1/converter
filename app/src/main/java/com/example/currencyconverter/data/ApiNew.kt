package com.example.currencyconverter.data


import com.example.currencyconverter.CurrencyModel
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET

interface ApiNew{

    @GET("XML_daily.asp")
    fun getValues(): Observable<CurrencyModel>


    companion object{
        fun createApiNew(): ApiNew{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.cbr.ru/scripts/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
            return retrofit.create(ApiNew::class.java)
        }
    }
}