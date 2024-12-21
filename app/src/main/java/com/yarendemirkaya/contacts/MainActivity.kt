package com.yarendemirkaya.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yarendemirkaya.contacts.ui.screen.ScreenPass
import com.yarendemirkaya.contacts.ui.theme.ContactsTheme
import com.yarendemirkaya.contacts.ui.viewmodel.DetailViewModel
import com.yarendemirkaya.contacts.ui.viewmodel.MainPageViewModel
import com.yarendemirkaya.contacts.ui.viewmodel.RegisterViewModel

class MainActivity : ComponentActivity() {
    val mainPageViewModel: MainPageViewModel by viewModels()
    val registerViewModel: RegisterViewModel by viewModels()
    val detailViewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsTheme {
               ScreenPass(mainPageViewModel,registerViewModel,detailViewModel)
            }
        }
    }
}
