package com.suqare.Interface

import com.suqare.model.SilentPayload

interface SilentListener {
    fun onSilentMessage(
        payload: SilentPayload
    )
}