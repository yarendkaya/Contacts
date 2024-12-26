package com.yarendemirkaya.contacts.retrofit

import com.yarendemirkaya.contacts.data.entity.CRUD
import com.yarendemirkaya.contacts.data.entity.ContactsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PersonDAO {
    // http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    // http://kasimadalan.pe.hu/ base url
    //kisiler/tum_kisiler.php

    @GET("kisiler/tum_kisiler.php ")
    suspend fun loadPersons(): ContactsResponse

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    suspend fun save(
        @Field("kisi_ad") personName: String,
        @Field("kisi_tel") personNumber: String
    ): CRUD

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    suspend fun update(
        @Field("kisi_id") personId: Int,
        @Field("kisi_ad") personName: String,
        @Field("kisi_tel") personNumber: String,
    ): CRUD

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun delete(
        @Field("kisi_id") personId: Int,
    ): CRUD

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun search(
        @Field("kisi_ad") searchWord: String
    ): ContactsResponse
}