package com.saulblanco.examplemvvm.data.model

import com.saulblanco.examplemvvm.data.model.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider:QuoteProvider) {
    //La primera vez que se conecta, recibe de la "api" la información, la almacena en memoria
    //en nuestra "BD"(QuoteProvider) y la devuelve
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}