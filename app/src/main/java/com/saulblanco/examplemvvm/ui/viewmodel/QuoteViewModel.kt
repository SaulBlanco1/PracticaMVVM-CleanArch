package com.saulblanco.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saulblanco.examplemvvm.data.model.QuoteModel
import com.saulblanco.examplemvvm.domain.GetQuotesUseCase
import com.saulblanco.examplemvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Con :ViewModel() le decimos que extienda de viewmodel
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate() {
        //Se lanza la corrutina y se controla sola automáticamente con el viewModelScope
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }

    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null) {
            quoteModel.postValue(quote)
        }

        isLoading.postValue(false)
    }


}