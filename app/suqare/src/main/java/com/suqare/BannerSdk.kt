package com.suqare

import android.app.Application
import android.util.Base64
object BannerSdk {
    private const val DEFAULT_SOCKET_URL ="https://api.yourdomain.com"
    private const val ENCODED_URL =
        "aHR0cDovLzE5Mi4xNjguMS40NjozMDAw"

    private fun getSocketUrl(): String {
        return String(
            Base64.decode(ENCODED_URL, Base64.DEFAULT)
        )
    }

    fun init(application: Application) {
        BannerManager.init(application)
        BannerSocketClient.connect(getSocketUrl(), application)
    }
}
/*
object BannerSdk {

    fun init(
        application: Application,
        socketUrl: String
    ) {
        BannerManager.init(application)
        BannerSocketClient.connect(socketUrl, application)
    }
}*/
