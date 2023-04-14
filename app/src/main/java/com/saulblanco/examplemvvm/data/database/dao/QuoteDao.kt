package com.saulblanco.examplemvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saulblanco.examplemvvm.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {

    //Colocamos la query de SQL
    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuotes(): List<QuoteEntity>

    //En caso de que introduzcamos dos campos con el mismo id, con onConflict indicas
    //Como actuar en caso de dicho conflicto
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<QuoteEntity>)

    @Query("DELETE FROM quote_table")
    suspend fun deleteAllQuotes()

}