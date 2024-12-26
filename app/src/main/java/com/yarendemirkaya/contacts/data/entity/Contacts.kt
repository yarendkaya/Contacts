package com.yarendemirkaya.contacts.data.entity

import com.google.gson.annotations.SerializedName

data class Contacts(
    @SerializedName("kisi_id")
    var personId: Int,
    @SerializedName("kisi_ad")
    var personName: String,
    @SerializedName("kisi_tel")
    var personNumber: String
)

