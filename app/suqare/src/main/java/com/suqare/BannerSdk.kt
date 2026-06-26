package com.suqare

import android.app.Application
import android.util.Base64
import com.suqare.Interface.SilentListener

object BannerSdk {
    private const val ENCODED_URL =
        "aHR0cHM6Ly9zdXFhcmUtYmFja2VuZG1pc2JhLm9ucmVuZGVyLmNvbQ=="
    private fun getSocketUrl(): String {
        return String(
            Base64.decode(ENCODED_URL, Base64.DEFAULT)
        )
    }
    var silentListener: SilentListener? = null
    fun init(application: Application) {
        BannerManager.init(application)
        BannerSocketClient.connect(
            getSocketUrl(),
            application
        )
    }
}
/*object BannerSdk {
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
}*/
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
