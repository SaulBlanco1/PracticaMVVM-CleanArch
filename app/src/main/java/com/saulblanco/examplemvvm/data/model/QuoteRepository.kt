package com.saulblanco.examplemvvm.data.model

import com.saulblanco.examplemvvm.data.model.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    //La primera vez que se conecta, recibe de la "api" la información, la almacena en memoria
    //en nuestra "BD"(QuoteProvider) y la devuelve
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}