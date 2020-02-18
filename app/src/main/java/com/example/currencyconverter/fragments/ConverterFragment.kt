package com.example.currencyconverter.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.example.currencyconverter.R
import com.example.currencyconverter.StringCase.currencyChar
import com.example.currencyconverter.StringCase.currencyName
import com.example.currencyconverter.StringCase.currencyValue
import com.example.currencyconverter.StringCase.normalCV
import com.example.currencyconverter.activities.ValuesListActivity
import kotlinx.android.synthetic.main.converter_fragment.*
import java.math.RoundingMode

class ConverterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.converter_fragment, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        char_txt.text = currencyChar
        value_birzha.text = normalCV
        value_name.text = currencyName

        currency_layout.setOnClickListener {
//            MaterialDialog(requireActivity())
//                .title(text = "Choose the currency")
//                .listItemsSingleChoice(items = listOf("USD", "EUR", "BYN", "CNY"), selection =  {dialog, index, text ->
//                    if (index == 0){
//                        value_name.text = "USD - Доллар США"
//                        char_txt.text = "USD"
//                        value_birzha.text = "63.4"
//                    }
//                    if (index == 1){
//                        value_name.text = "EUR - Евро"
//                        char_txt.text = "EUR"
//                        value_birzha.text = "68.77"
//                    }
//                    if (index == 2){
//                        value_name.text = "Белорусский рубль"
//                        char_txt.text = "BYN"
//                        value_birzha.text = "28.85"
//                    }
//                    if (index == 3){
//                        value_name.text = "Китайских юаней"
//                        char_txt.text = "CNY"
//                        value_birzha.text = "90.91"
//                    }
//                    dialog.cancel()
//                }).show {}
            startActivity(Intent(requireActivity(), ValuesListActivity::class.java))
        }

        convert_btn.setOnClickListener {
            var rub = "0".toFloat()
            if (rub_money.text.isNotEmpty()) {
                rub = rub_money.text.toString().toFloat()
            }
            var dollar = value_birzha.text.toString().toFloat()
            value_money.text =
                (rub / dollar).toBigDecimal().setScale(2, RoundingMode.HALF_DOWN).toString()

        }
    }

    override fun onResume() {
        super.onResume()

        char_txt.text = currencyChar
        value_birzha.text = currencyValue
        value_name.text = currencyName
    }
}