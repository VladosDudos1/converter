package com.example.currencyconverter

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "CurrencyModel", strict = false)
class CurrencyModel {
    @field:ElementList(inline = true)
    var Valute: List<Valute>? = null
}