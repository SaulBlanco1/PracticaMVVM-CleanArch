package com.saulblanco.examplemvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saulblanco.examplemvvm.domain.model.Quote

//Nombre de la tabla "quote_table" // campos de la tabla "author" y "quote"
@Entity(tableName="quote_table")
data class QuoteEntity(
    //Indicamos que ID es la primary key y la hacemos "autoincremental" con autoGenerate
    //Solo le tendremos que pasar quote y author y la id se generará sola
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int=0,
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String
)

//Función de extensión
fun Quote.toDatabase() = QuoteEntity(quote= quote, author=author)