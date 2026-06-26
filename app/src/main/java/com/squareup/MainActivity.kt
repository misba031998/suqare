package com.squareup

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.suqare.BannerSdk
import com.suqare.Interface.SilentListener
import com.suqare.model.SilentPayload

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        BannerSdk.init(application)

        /*private fun getSocketUrl(): String {
                val p1 = "http://"
                val p2 = "192.168."
                val p3 = "1.46"
                val p4 = ":3000"
                return p1 + p2 + p3 + p4
            }*/

        BannerSdk.silentListener = object : SilentListener {
            override fun onSilentMessage(payload: SilentPayload) {
                Log.e("TAG", "onSilentMessage: $payload")
            }
        }
    }
}