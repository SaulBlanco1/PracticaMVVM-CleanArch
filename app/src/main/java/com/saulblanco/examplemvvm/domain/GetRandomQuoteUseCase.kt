package com.saulblanco.examplemvvm.domain

import com.saulblanco.examplemvvm.data.model.QuoteModel
import com.saulblanco.examplemvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider){


    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}