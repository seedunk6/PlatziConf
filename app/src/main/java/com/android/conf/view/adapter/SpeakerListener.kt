package com.android.conf.view.adapter

import com.android.conf.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}