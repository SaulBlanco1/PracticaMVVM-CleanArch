package com.saulblanco.examplemvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
    //CompanionObject es como una clase estatica
    var quotes: List<QuoteModel> = emptyList()

}