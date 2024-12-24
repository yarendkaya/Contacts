package com.yarendemirkaya.contacts.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yarendemirkaya.contacts.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel@Inject constructor(private var contactsRepository: ContactsRepository):ViewModel() {
    fun register(personName: String, personNumber: String) {
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.register(personName, personNumber)
        }
    }
}