package com.saulblanco.examplemvvm.domain

import com.saulblanco.examplemvvm.data.database.entities.toDatabase
import com.saulblanco.examplemvvm.data.model.QuoteModel
import com.saulblanco.examplemvvm.data.model.QuoteRepository
import com.saulblanco.examplemvvm.domain.model.Quote
import javax.inject.Inject

//Un caso de uso se encarga de realizar una única tarea, como podría ser
//recuperar la información de las quotes y generar una aleatoria y devolverla
class GetQuotesUseCase @Inject constructor(
    private val repository:QuoteRepository
) {

    //Esta función se ejecuta cuando se llama a GetQuotesUseCase() directamente
    suspend operator fun invoke() : List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map{it.toDatabase()})
            quotes

        }else{
            //En caso de fallar la conexión a la API, devuelve una lista vacía de Quotes,
            //Y para no pasar esa lista, recogemos del repositorio local una lista, aunque
            //no esté actualizada
            repository.getAllQuotesFromDatabase()
        }

    }


}