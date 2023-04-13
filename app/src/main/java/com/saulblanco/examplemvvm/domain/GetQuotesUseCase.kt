package com.saulblanco.examplemvvm.domain

import com.saulblanco.examplemvvm.data.model.QuoteModel
import com.saulblanco.examplemvvm.data.model.QuoteRepository
import javax.inject.Inject

//Un caso de uso se encarga de realizar una única tarea, como podría ser
//recuperar la información de las quotes y generar una aleatoria y devolverla
class GetQuotesUseCase @Inject constructor(
    private val repository:QuoteRepository
) {

    //Esta función se ejecuta cuando se llama a GetQuotesUseCase() directamente
    suspend operator fun invoke() = repository.getAllQuotes()


}