package com.suqare


import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import com.google.gson.Gson
import com.suqare.model.BannerPayload

object BannerManager {
    private var currentActivity: Activity? = null
    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(
            object : Application.ActivityLifecycleCallbacks {
                override fun onActivityResumed(activity: Activity) {
                    currentActivity = activity
                }
                override fun onActivityCreated(a: Activity, b: Bundle?) {}
                override fun onActivityStarted(a: Activity) {}
                override fun onActivityPaused(a: Activity) {}
                override fun onActivityStopped(a: Activity) {}
                override fun onActivitySaveInstanceState(a: Activity, b: Bundle) {}
                override fun onActivityDestroyed(a: Activity) {}
            }
        )
    }
    fun showBanner(payload: BannerPayload) {
        val activity = currentActivity ?: return
        val intent = Intent(activity, BannerActivity::class.java)
        intent.putExtra("data", Gson().toJson(payload))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
    }
}