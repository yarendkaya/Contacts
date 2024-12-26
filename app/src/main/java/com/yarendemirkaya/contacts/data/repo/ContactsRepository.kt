package com.yarendemirkaya.contacts.data.repo

import com.yarendemirkaya.contacts.data.datasource.ContactsDataSource
import com.yarendemirkaya.contacts.data.entity.Contacts
import javax.inject.Inject

class ContactsRepository @Inject constructor(private val contactsDataSource: ContactsDataSource) {
    suspend fun uploadContacts(): List<Contacts> =
        contactsDataSource.uploadContacts()

    suspend fun register(personName: String, personNumber: String) =
        contactsDataSource.register(personName, personNumber)

    suspend fun update(personId: Int, personName: String, personNumber: String) =
        contactsDataSource.update(personId, personName, personNumber)

    suspend fun delete(personId: Int) =
        contactsDataSource.delete(personId)


    suspend fun search(searchWord: String): List<Contacts> =
        contactsDataSource.search(searchWord)
}