package com.example.currencyconverter.data

import android.content.Context
import android.content.SharedPreferences

class DataManager {
    private val baseContext: Context
    private val shared: SharedPreferences


    val apiNew = ApiNew.createApiNew()
    val api = Api.createApi()

    constructor(baseContext: Context){
        this.baseContext = baseContext
        shared = baseContext.getSharedPreferences("Srez", Context.MODE_PRIVATE)
    }

    fun firstLaunch() : Boolean = shared.getBoolean("isFirstLaunch", true)

    fun endFirstLaunch() : Boolean = shared.edit().putBoolean("isFirstLaunch", false).commit()

}