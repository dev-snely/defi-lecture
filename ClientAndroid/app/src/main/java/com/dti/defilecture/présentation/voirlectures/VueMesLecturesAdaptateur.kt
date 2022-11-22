package com.dti.defilecture.présentation.voirlectures


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Lecture

class VueMesLecturesAdaptateur(private val lectures : MutableList<Lecture>?) :
    RecyclerView.Adapter<VueMesLecturesAdaptateur.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rangee_lectures
        ,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = lectures?.get(position)
        if (currentItem != null){
            holder.titre.text = currentItem.titreLecture
            holder.duree.text = currentItem.duréeMinutes.toString() + " minutes"
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