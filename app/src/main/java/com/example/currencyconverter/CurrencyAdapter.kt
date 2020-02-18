package com.example.currencyconverter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import com.example.currencyconverter.StringCase.currencyChar
import com.example.currencyconverter.StringCase.currencyName
import com.example.currencyconverter.StringCase.currencyValue
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.currency_view.view.*

class CurrencyAdapter(val list: List<Valute>, val onClickListener: OnClickListener) : RecyclerView.Adapter<CurrencyAdapter.CurrencyView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyView = CurrencyView(LayoutInflater.from(parent.context)
        .inflate(R.layout.currency_view, parent, false))



    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CurrencyView, position: Int) {
        val valute = list[position]
        holder.itemView.dollar_txt.text = valute.Name
        holder.itemView.setOnClickListener {
            onClickListener.click(list[position])

            currencyChar = list[position].CharCode.toString()
            currencyName = list[position].Name.toString()
            currencyValue = list[position].Value.toString()
        }

    }
    class CurrencyView : RecyclerView.ViewHolder{
        constructor(view: View): super(view)
    }
    interface OnClickListener {
        fun click(data: Valute)
    }
}