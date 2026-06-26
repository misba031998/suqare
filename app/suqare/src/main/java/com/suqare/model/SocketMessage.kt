package com.suqare.model

import com.google.gson.JsonObject

data class SocketMessage(
    val type: String,
    val targetType: String,
    val packageName: String? = null,
    val deviceId: String? = null,
    val payload: JsonObject
)
