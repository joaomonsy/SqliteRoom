package com.example.sqliteroom.controller

import androidx.room.Database

@Database(
    entities = [Contato::class],
    version = 1
)

abstract class ContatoDatabase {

}