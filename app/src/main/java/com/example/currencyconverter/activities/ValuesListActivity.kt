package com.example.currencyconverter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.CurrencyAdapter
import com.example.currencyconverter.R
import com.example.currencyconverter.Valute
import com.example.currencyconverter.app.App
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_values_list.*
import kotlinx.android.synthetic.main.converter_fragment.*

class ValuesListActivity : AppCompatActivity(), CurrencyAdapter.OnClickListener {

    private val manager = supportFragmentManager

    override fun click(data: Valute){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_values_list)

        back_to_converter_btn.setOnClickListener(this::backMain)


//        dollar_txt.setOnClickListener(this::)
//        euro_txt.setOnClickListener(this::)
//        a_dollar_txt.setOnClickListener(this::)
//        b_rub_txt.setOnClickListener(this::)
//        d_cron_txt.setOnClickListener(this::)
//
        rv.layoutManager =LinearLayoutManager(this)

        val disp = App.dm.apiNew
            .getValues()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({c ->
                rv.adapter = CurrencyAdapter(c.Valute!!, this)

            },{
                Log.d("","")
            })

    }



    fun backMain(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}
