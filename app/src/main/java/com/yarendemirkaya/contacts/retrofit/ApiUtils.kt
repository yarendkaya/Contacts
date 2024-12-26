package com.yarendemirkaya.contacts.retrofit

class ApiUtils {
    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"
        fun getKisilerDao():KisilerDAO{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDAO::class.java)
        }
    }
}