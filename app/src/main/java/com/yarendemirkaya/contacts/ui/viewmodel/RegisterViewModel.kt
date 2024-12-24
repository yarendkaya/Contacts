package com.yarendemirkaya.contacts.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yarendemirkaya.contacts.data.repo.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel:ViewModel() {
    var contactsRepository= ContactsRepository()
    fun register(personName: String, personNumber: String) {
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.register(personName, personNumber)
        }
    }
}