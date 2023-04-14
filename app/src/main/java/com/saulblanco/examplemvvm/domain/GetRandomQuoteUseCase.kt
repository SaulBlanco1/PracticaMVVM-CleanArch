package com.saulblanco.examplemvvm.domain

import com.saulblanco.examplemvvm.data.model.QuoteModel
import com.saulblanco.examplemvvm.data.model.QuoteRepository
import com.saulblanco.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository ){
    suspend operator fun invoke(): Quote? {

        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}