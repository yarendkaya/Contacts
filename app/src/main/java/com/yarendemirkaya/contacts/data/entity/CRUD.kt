package com.yarendemirkaya.contacts.data.entity

import com.google.gson.annotations.SerializedName

data class CRUD(
    @SerializedName("success")
    var success: Int,
    @SerializedName("message")
    var message: String) {
}