package com.yarendemirkaya.contacts.data.datasource

import com.yarendemirkaya.contacts.data.entity.Contacts
import com.yarendemirkaya.contacts.retrofit.PersonDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource(var personDao: PersonDAO) {
    suspend fun register(personName: String, personNumber: String) {
       personDao.save(personName, personNumber)
    }


    suspend fun update(personId: Int, personName: String, personNumber: String) {
        personDao.update(personId, personName, personNumber)
    }

    suspend fun delete(personId: Int) {
        personDao.delete(personId)
    }

    suspend fun uploadContacts() :List<Contacts> = withContext(Dispatchers.IO) {
        return@withContext personDao.loadPersons().contacts
    }

    suspend fun search(searchWord: String) :List<Contacts> = withContext(Dispatchers.IO) {
        return@withContext personDao.search(searchWord).contacts
    }
}