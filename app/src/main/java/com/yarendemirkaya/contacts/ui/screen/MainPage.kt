package com.yarendemirkaya.contacts.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.google.gson.Gson
import com.yarendemirkaya.contacts.R
import com.yarendemirkaya.contacts.data.entity.Contacts


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController) {
    val isSearchable = remember { mutableStateOf(false) }
    val tfSearch = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearchable.value) {
                        Text(text = "Search")
                    }else
                        Text(text = "Contacts")

                },
                actions = {
                    if (isSearchable.value) {
                        IconButton(onClick = {isSearchable.value = false}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = "Close"
                            )
                        }
                    }
                    IconButton(onClick = {isSearchable.value = true}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search"
                        )
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("register")
                },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add"
                    )
                }
            )
        }
    )
    { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    val person = Contacts(1, "yaren", "22")
                    val personJson = Gson().toJson(person)

                    navController.navigate("detail/${personJson}")
                }
            ) {
                Text(text = "Detail")
            }
        }
    }
}