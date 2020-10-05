package com.android.conf.view.adapter

import com.android.conf.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}