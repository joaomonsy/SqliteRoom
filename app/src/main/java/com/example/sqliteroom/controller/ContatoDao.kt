package com.example.sqliteroom.controller

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.sqliteroom.model.Contato
import kotlinx.coroutines.flow.Flow


@Dao
interface ContatoDao {
    @Upsert
    suspend fun upsertContato (contato: Contato)

    @Delete
    suspend fun deleteContato (contato: Contato)

    @Query("SELECT * FROM contatos ORDER BY nome ASC")
    fun getContatoOrdenadoPeloNome(): Flow<List<Contato>>

    @Query("SELECT * FROM contatos ORDER BY sobrenome ASC")
    fun getContatoOrdenadoPeloSobrenome(): Flow<List<Contato>>

    @Query("SELECT * FROM contatos ORDER BY telefone ASC")
    fun getContatoOrdenadoPeloTelefone(): Flow<List<Contato>>
}