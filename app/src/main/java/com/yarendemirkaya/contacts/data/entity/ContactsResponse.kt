package com.yarendemirkaya.contacts.data.entity

import com.google.gson.annotations.SerializedName

data class ContactsResponse(
    @SerializedName("kisiler")
    var contacts: List<Contacts>,
    @SerializedName("success")
    var success: Int) {

}