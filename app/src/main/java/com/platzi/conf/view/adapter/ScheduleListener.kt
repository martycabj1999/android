package com.platzi.conf.view.adapter

import com.platzi.conf.model.Torneo

interface ScheduleListener {
    fun onTorneoClicked(torneo: Torneo, position: Int)
}