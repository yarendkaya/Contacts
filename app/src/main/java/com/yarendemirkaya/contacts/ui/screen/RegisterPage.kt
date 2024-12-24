package com.yarendemirkaya.contacts.ui.screen

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
import com.yarendemirkaya.contacts.ui.viewmodel.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(registerViewModel: RegisterViewModel) {
    val tfName = remember { mutableStateOf("") }
    val tfNumber = remember { mutableStateOf("") }



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
                registerViewModel.register(tfName.value, tfNumber.value)
            }
            ) {
                Text(text = "Save")
            }
        }
    }
}