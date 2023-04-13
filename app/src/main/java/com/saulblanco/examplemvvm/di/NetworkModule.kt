package com.saulblanco.examplemvvm.di

import com.saulblanco.examplemvvm.data.model.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) // EL alcance que queremos que tenga
object NetworkModule {

    //proveo Retrofit
    @Singleton // Sirve para crear una sola instancia de Retrofit y no tener muchas creadas
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit:Retrofit): QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }

}