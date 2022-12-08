package com.dti.defilecture.présentation.voirlectures

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Lecture

class VueMesLecturesAdaptateur(private val lectures : MutableList<Lecture>?) :
    RecyclerView.Adapter<VueMesLecturesAdaptateur.MyViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rangee_lectures,parent, false)

        context = parent.context

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = lectures?.get(position)
        if (currentItem != null){
            holder.titre.text = currentItem.titreLecture
            //holder.duree.text = "${currentItem.duréeMinutes} minutes"
            holder.duree.text = context.resources.getString(R.string.nbMinute, currentItem.duréeMinutes)
            holder.date.text = currentItem.dateInscription
            holder.oblig.text = if (currentItem.obligatoire == true) "OBLIGATOIRE" else "LIBRE"
        }
    }

    override fun getItemCount(): Int {
        return lectures?.size!!
    }

    class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){
        val titre: TextView = itemView.findViewById(R.id.titreDUneLecture)
        val duree: TextView = itemView.findViewById(R.id.dureeDUneLecture)
        val date: TextView = itemView.findViewById(R.id.dateDUneLecture)
        val oblig: TextView = itemView.findViewById(R.id.obligationDUneLecture)
    }
}