package com.yarendemirkaya.contacts.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yarendemirkaya.contacts.data.entity.Contacts
import com.yarendemirkaya.contacts.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(private var contactsRepository: ContactsRepository) :
    ViewModel() {
    var contactsList = MutableLiveData<List<Contacts>>()

    init {
        uploadContacts()
    }

    fun delete(personId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.delete(personId)
            uploadContacts()
        }
    }

     fun uploadContacts() {
        CoroutineScope(Dispatchers.Main).launch {
//            contactsRepository.uploadContacts()
            contactsList.value = contactsRepository.uploadContacts()
        }
    }

    fun search(searchWord: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                contactsList.value = contactsRepository.search(searchWord)
            } catch (_: Exception) {
            }
        }
    }
}