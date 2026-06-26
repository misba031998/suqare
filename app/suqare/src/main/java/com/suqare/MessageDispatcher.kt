package com.suqare

import android.app.Application
import com.google.gson.Gson
import com.suqare.model.BannerPayload
import com.suqare.model.NotificationPayload
import com.suqare.model.SilentPayload
import com.suqare.model.SocketMessage

object MessageDispatcher {
    fun dispatch(
        application: Application,
        message: SocketMessage
    ) {
        when (message.type) {
            "banner" -> {
                val banner = Gson().fromJson(
                    message.payload,
                    BannerPayload::class.java
                )
                BannerManager.showBanner(banner)
            }
            "notification" -> {
                val notification = Gson().fromJson(
                    message.payload,
                    NotificationPayload::class.java
                )
                /*NotificationHelper.show(
                    application,
                    notification
                )*/
            }
            "silent" -> {
                val silent = Gson().fromJson(
                    message.payload,
                    SilentPayload::class.java
                )
                BannerSdk.silentListener?.onSilentMessage(silent)
            }
        }
    }

}