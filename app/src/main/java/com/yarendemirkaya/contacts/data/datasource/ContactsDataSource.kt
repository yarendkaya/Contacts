package com.yarendemirkaya.contacts.data.datasource

import android.util.Log
import com.yarendemirkaya.contacts.data.entity.Contacts
import com.yarendemirkaya.contacts.retrofit.KisilerDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource(var kisilerDao: KisilerDAO) {
    suspend fun register(kisi_ad: String, kisi_tel: String) {
       kisilerDao.kaydet(kisi_ad, kisi_tel)
    }

    suspend fun update(personId: Int, personName: String, personNumber: String) {
        kisilerDao.guncelle(personId, personName, personNumber)
    }

    suspend fun delete(personId: Int) {
        kisilerDao.sil(personId)
    }

    suspend fun uploadContacts() :List<Contacts> = withContext(Dispatchers.IO) {
        return@withContext kisilerDao.kisileriYukle().kisiler
    }

    suspend fun search(searchWord: String) :List<Contacts> = withContext(Dispatchers.IO) {
        return@withContext kisilerDao.search(searchWord).kisiler
    }
}