package com.suqare

import android.app.Application
import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import com.suqare.model.BannerPayload
import io.socket.client.IO
import io.socket.client.Socket

object BannerSocketClient {

    private var socket: Socket? = null

    fun connect(url: String, application: Application) {

        try {
            socket = IO.socket(url)
            socket?.connect()

            socket?.on("show-banner") { args ->

                val json = args[0].toString()

                val banner = Gson().fromJson(
                    json,
                    BannerPayload::class.java
                )

                Handler(Looper.getMainLooper()).post {
                    BannerManager.showBanner(banner)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}