package com.dti.defilecture.présentation.modèle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Personne

class MyAdapter (private val personneListe: ArrayList<Personne>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.liste_personnes,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = personneListe[position]
        holder.personneNom.text = currentItem.nomPersonne
        holder.personneDoublons.text = currentItem.doublonsPersonne.toString()
    }

    override fun getItemCount(): Int {

        return personneListe.size
    }

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val personneNom : TextView = itemView.findViewById(R.id.personneNom)
        val personneDoublons : TextView = itemView.findViewById(R.id.personneDoublons)
    }
}