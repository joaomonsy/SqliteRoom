package com.example.sqliteroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.sqliteroom.controller.ContatoDatabase
import com.example.sqliteroom.controller.ContatoExec
import com.example.sqliteroom.ui.theme.SqliteRoomTheme

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            ContatoDatabase::class.java,
            "contato.db"
        ).build()
    }

    private val viewModel by viewModels<ContatoExec>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ContatoExec(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SqliteRoomTheme {
                val estado by viewModel.estado.collectAsState()
                ContatoTela(estado = estado, evento = viewModel::evento)
            }
        }
    }
}