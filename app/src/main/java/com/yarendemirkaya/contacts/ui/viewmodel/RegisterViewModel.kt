package com.yarendemirkaya.contacts.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yarendemirkaya.contacts.data.repo.ContactsRepository

class RegisterViewModel:ViewModel() {
    var contactsRepository= ContactsRepository()
}