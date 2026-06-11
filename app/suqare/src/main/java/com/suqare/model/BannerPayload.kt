package com.suqare.model

data class BannerPayload(
    val id: String,
    val title: String,
    val message: String,
    val imageUrl: String?,
    val buttonText: String?,
    val deepLink: String?,
    val dismissible: Boolean = true
)
