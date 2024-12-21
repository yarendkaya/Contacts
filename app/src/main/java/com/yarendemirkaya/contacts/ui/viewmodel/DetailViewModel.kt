package com.yarendemirkaya.contacts.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yarendemirkaya.contacts.data.repo.ContactsRepository

class DetailViewModel : ViewModel() {
    var contactsRepository = ContactsRepository()
}