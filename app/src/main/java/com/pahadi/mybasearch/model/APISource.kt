package com.pahadi.mybasearch.model

import com.google.gson.annotations.SerializedName

data class APISource(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String = "",
)


