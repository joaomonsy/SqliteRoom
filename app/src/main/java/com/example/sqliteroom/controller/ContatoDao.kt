package com.example.sqliteroom.controller

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.sqliteroom.model.Contato

@Dao
interface ContatoDao {
    @Insert
    fun insertContato(contato: Contato)
    @Update
    fun updateContato(contato: Contato)
    @Delete
    fun deleteContato(contato: Contato)

    @Query("SELECT * from contatos ORDER BY nome ASC")
    fun getContatoOrdenadoPeloNome()

    @Query("SELECT * from contatos ORDER BY sobrenome ASC")
    fun getContatoOrdenadoPeloSobrenome()

    @Query("SELECT * from contatos ORDER BY telefone ASC")
    fun getContatoOrdenadoPeloTelefone()
}