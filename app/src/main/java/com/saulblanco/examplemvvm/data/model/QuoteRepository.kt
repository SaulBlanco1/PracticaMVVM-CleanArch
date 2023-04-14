package com.saulblanco.examplemvvm.data.model

import com.saulblanco.examplemvvm.data.database.dao.QuoteDao
import com.saulblanco.examplemvvm.data.database.entities.QuoteEntity
import com.saulblanco.examplemvvm.data.model.network.QuoteService
import com.saulblanco.examplemvvm.domain.model.Quote
import com.saulblanco.examplemvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {
    //La primera vez que se conecta, recibe de la "api" la información, la almacena en memoria
    //en nuestra "BD"(QuoteProvider) y la devuelve
    suspend fun getAllQuotesFromApi(): List<Quote> {
        //La respuesta es una lista de QuoteModel, el "map" es como un "for"
        //recorre la lista y ejecuta el método toDomain en cada uno con el iterador "it"
        //Y los convierte en "Quote"
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map{it.toDomain()}

    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }


}