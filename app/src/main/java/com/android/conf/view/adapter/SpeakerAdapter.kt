package com.android.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.conf.R
import com.android.conf.model.Speaker
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.collections.ArrayList

class SpeakerAdapter (val speakerListener: SpeakerListener): RecyclerView.Adapter<SpeakerAdapter.ViewHolder>(){

    var listSpeaker = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_speaker, parent, false))

    override fun getItemCount() = listSpeaker.size

    override fun onBindViewHolder(holder: SpeakerAdapter.ViewHolder, position: Int) {
        val speaker = listSpeaker[position] as Speaker

        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivItemSpeakerImage)

        holder.tvItemSpeakerName.text = speaker.name
        holder.tvItemSpeakerWorkplace.text = speaker.workplace

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClicked(speaker, position)
        }

    }

    fun updateDate(data: List<Speaker>){
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivItemSpeakerImage = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage)
        val tvItemSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvItemSpeakerWorkplace = itemView.findViewById<TextView>(R.id.tvItemSpeakerWorkplace)

    }

}