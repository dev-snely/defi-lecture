package com.dti.defilecture.présentation.voirlectures

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Lecture

class VueMesLecturesAdaptateur( var lectures : MutableList<Lecture> = mutableListOf() ) :
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
            val res = context.resources
            holder.titre.text = currentItem.titreLecture
            holder.duree.text = res.getString(R.string.nbMinute, currentItem.duréeMinutes)
            holder.date.text = currentItem.dateInscription
            holder.oblig.text = if (currentItem.obligatoire == true) res.getString(R.string.obligatoire) else res.getString(R.string.libre)
            holder.effacer.setOnClickListener(){
                val builder = AlertDialog.Builder(context)
                builder.setMessage("Êtes-vous certain d'effacer cette lecture?")
                builder.setPositiveButton(res.getString(R.string.oui)) { dialog, id -> }
                builder.setNegativeButton(res.getString(R.string.non)) { dialog, id -> }
                builder.create().show()
            }
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
        val effacer: ImageButton = itemView.findViewById(R.id.ic_EffacerLecture)
    }
}