package com.yarendemirkaya.contacts.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yarendemirkaya.contacts.data.repo.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    var contactsRepository = ContactsRepository()

    fun update(personId: Int, personName: String, personNumber: String) {
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.update(personId, personName, personNumber)
        }
    }
}