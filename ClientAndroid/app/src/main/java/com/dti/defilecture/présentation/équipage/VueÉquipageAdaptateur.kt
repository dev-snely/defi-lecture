package com.dti.defilecture.présentation.équipage


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Compte

class VueÉquipageAdaptateur(private val comptes : MutableList<Compte>?) :
    RecyclerView.Adapter<VueÉquipageAdaptateur.MyViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_equipage
        ,parent, false)

        context = parent.context

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = comptes?.get(position)
        if (currentItem != null){
            holder.pseudonyme.text = currentItem.pseudonymeCompte

            holder.doublons.text = currentItem.doublonsCompte.toString()
        }

    }

    override fun getItemCount(): Int {
        return comptes?.size!!
    }

    class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){
        val pseudonyme: TextView = itemView.findViewById(R.id.tv_itemPseudonyme)
        val doublons: TextView = itemView.findViewById(R.id.tv_itemCompteTotalDoublon)
    }

}