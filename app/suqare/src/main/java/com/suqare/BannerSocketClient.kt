package com.suqare

import android.provider.Settings;
import android.app.Application
import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import com.suqare.model.BannerPayload
import com.suqare.model.SocketMessage
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONObject

object BannerSocketClient {
    private var socket: Socket? = null
    fun connect(url: String, application: Application) {
        socket = IO.socket(url)
        socket?.on(Socket.EVENT_CONNECT) {
            register(application)
        }
        socket?.on("message") { args ->
            val json = args[0].toString()
            val message = Gson().fromJson(
                json,
                SocketMessage::class.java
            )
            Handler(Looper.getMainLooper()).post {
                MessageDispatcher.dispatch(
                    application,
                    message
                )
            }
        }
        socket?.connect()
    }
    private fun register(application: Application) {
        val obj = JSONObject()
        obj.put(
            "packageName",
            application.packageName
        )
        obj.put(
            "deviceId",
            Settings.Secure.getString(
                application.contentResolver,
                Settings.Secure.ANDROID_ID
            )
        )
        socket?.emit("register", obj)
    }
}

/*
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
}*/
