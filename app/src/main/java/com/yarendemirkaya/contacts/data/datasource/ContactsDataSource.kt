package com.yarendemirkaya.contacts.data.datasource

import android.util.Log
import com.yarendemirkaya.contacts.data.entity.Contacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource {
    suspend fun register(personName: String, personNumber: String) {
        Log.e("Contacts", "Register")
    }

    suspend fun update(personId: Int, personName: String, personNumber: String) {
        Log.e("Update", "$personId - $personName - $personNumber")
    }

    suspend fun delete(personId: Int) {
        Log.e("Delete", personId.toString())
    }

    suspend fun uploadContacts() :List<Contacts> = withContext(Dispatchers.IO) {
        val contactsList = ArrayList<Contacts>()
        val k1 = Contacts(1, "yaren", "22")
        val k2 = Contacts(2, "ali", "23")
        val k3 = Contacts(3, "mehmet", "29")
        contactsList.add(k1)
        contactsList.add(k2)
        contactsList.add(k3)

        return@withContext contactsList
    }

    suspend fun search(searchWord: String) :List<Contacts> = withContext(Dispatchers.IO) {
        val contactsList = ArrayList<Contacts>()
        val k1 = Contacts(1, "yaren", "22")
        contactsList.add(k1)

        return@withContext contactsList
    }
}