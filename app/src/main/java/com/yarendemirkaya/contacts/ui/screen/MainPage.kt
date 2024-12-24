package com.yarendemirkaya.contacts.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.yarendemirkaya.contacts.R
import com.yarendemirkaya.contacts.ui.viewmodel.MainPageViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController, mainPageViewModel: MainPageViewModel) {
    val isSearchable = remember { mutableStateOf(false) }
    val tfSearch = remember { mutableStateOf("") }
    val contactsList = mainPageViewModel.contactsList.observeAsState(listOf()).value

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearchable.value) {
                        TextField(
                            value = tfSearch.value,
                            onValueChange = {
                                tfSearch.value = it
                                mainPageViewModel.search(it)
                            },
                            label = { Text(text = "Search") },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.Black,
                                unfocusedIndicatorColor = Color.White

                            )
                        )
                    } else {
                        Text(text = "Contacts")
                    }
                },
                actions = {
                    if (isSearchable.value) {
                        IconButton(onClick = {
                            isSearchable.value = false
                            tfSearch.value = ""
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = "Close"
                            )
                        }
                    } else {
                        IconButton(onClick = { isSearchable.value = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "Search"
                            )
                        }
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
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    )
    { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(count = contactsList.count(),
                itemContent = {
                    val person = contactsList[it]
                    Card(modifier = Modifier.padding(all = 5.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    val personJson = Gson().toJson(person)
                                    navController.navigate("detail/$personJson")
                                },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column(modifier = Modifier.padding(all = 10.dp)) {
                                Text(text = person.personName, fontSize = 20.sp)
                                Text(text = person.personNumber)

                            }
                            IconButton(onClick = {
                                scope.launch {
                                    val snackbar = snackbarHostState.showSnackbar(
                                        message = "${person.personName} delete?",
                                        actionLabel = "Yes"
                                    )
                                    if (snackbar == SnackbarResult.ActionPerformed) {
                                        mainPageViewModel.delete(person.personId)

                                    }
                                }
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_close),
                                    contentDescription = "", tint = Color.Gray
                                )
                            }
                        }
                    }
                })
        }
    }
}