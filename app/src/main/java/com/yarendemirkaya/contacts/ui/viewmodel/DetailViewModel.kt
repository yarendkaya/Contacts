package com.yarendemirkaya.contacts.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yarendemirkaya.contacts.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val contactsRepository: ContactsRepository) : ViewModel() {
    fun update(personId: Int, personName: String, personNumber: String) {
        CoroutineScope(Dispatchers.Main).launch {
            contactsRepository.update(personId, personName, personNumber)
        }
    }
}