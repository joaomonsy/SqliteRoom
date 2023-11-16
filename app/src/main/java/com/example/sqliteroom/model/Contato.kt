package com.example.sqliteroom.model

import com.example.sqliteroom.controller.Tipos

data class Contato(
    val contato: List<Contato> = emptyList(),
    val nome: String = "",
    val sobrenome: String = "",
    val telefone: String = "",
    val adicionarContato: Boolean = false,
    val tipos: Tipos = Tipos.nome
)
