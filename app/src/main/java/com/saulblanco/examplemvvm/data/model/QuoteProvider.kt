package com.saulblanco.examplemvvm.data.model

class QuoteProvider {
    //CompanionObject es como una clase estatica
    companion object {
        var quotes: List<QuoteModel> = emptyList()
    }
}