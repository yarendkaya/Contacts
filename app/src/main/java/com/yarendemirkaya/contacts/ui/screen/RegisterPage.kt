package com.yarendemirkaya.contacts.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage() {
    val tfName = remember { mutableStateOf("") }
    val tfNumber = remember { mutableStateOf("") }

    fun register(personName: String, personNumber: String) {
        Log.e("Register", "$personName - $personNumber")
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Register") })
    })
    { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = tfName.value,
                onValueChange = { tfName.value = it },
                label = { Text(text = "Name") })
            TextField(
                value = tfNumber.value,
                onValueChange = { tfNumber.value = it },
                label = { Text(text = "Number") })

            Button(onClick = {
                register(tfName.value, tfNumber.value)
            }
            ) {
                Text(text = "Save")
            }
        }
    }
}