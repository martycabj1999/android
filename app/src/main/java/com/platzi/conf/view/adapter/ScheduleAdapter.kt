package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.model.Torneo
import com.platzi.conf.R
import com.platzi.conf.view.ui.fragments.TorneoFragment
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TorneoAdapter(val scheduleListener: TorneoFragment) : RecyclerView.Adapter<TorneoAdapter.ViewHolder>() {

    var listTorneo = ArrayList<Torneo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))

    override fun getItemCount() = listTorneo.size

    override fun onBindViewHolder(holder: TorneoAdapter.ViewHolder, position: Int) {
        val torneo = listTorneo[position] as Torneo

        holder.tvTorneoName.text = torneo.name
        holder.tvTorneoSpeaker.text = torneo.puntos
        holder.tvTorneoTag.text = torneo.promedio

        holder.tvTorneoHour.text = torneo.website
        holder.tvTorneoAMPM.text = torneo.image

        holder.itemView.setOnClickListener {
            scheduleListener.onTorneoClicked(torneo, position)
        }

    }

    fun updateData(data: List<Torneo>) {
        listTorneo.clear()
        listTorneo.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTorneoName = itemView.findViewById<TextView>(R.id.tvItemTorneoTorneoName)
        val tvTorneoSpeaker = itemView.findViewById<TextView>(R.id.tvItemTorneoTorneoSpeaker)
        val tvTorneoTag = itemView.findViewById<TextView>(R.id.tvItemTorneoTag)
        val tvTorneoHour = itemView.findViewById<TextView>(R.id.tvItemTorneoHour)
        val tvTorneoAMPM = itemView.findViewById<TextView>(R.id.tvItemTorneoAMPM)
    }

}