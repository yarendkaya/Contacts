package com.yarendemirkaya.contacts.retrofit

class ApiUtils {
    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"
        fun getPersonDao():PersonDAO{
            return RetrofitClient.getClient(BASE_URL).create(PersonDAO::class.java)
        }
    }
}