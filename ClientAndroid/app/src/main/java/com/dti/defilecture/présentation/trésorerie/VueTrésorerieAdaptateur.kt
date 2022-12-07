package com.dti.defilecture.présentation.trésorerie


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Équipage

class VueTrésorerieAdaptateur(private val équipages : MutableList<Équipage>?, var présentateur: IContratVPTrésorerie.IPrésentateurTrésorerie) :
    RecyclerView.Adapter<VueTrésorerieAdaptateur.MyViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tresorerie
        ,parent, false)

        context = parent.context

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = équipages?.get(position)
        if (currentItem != null){
            holder.nom.text = currentItem.nomÉquipage
            holder.doublons.text = currentItem.doublonsÉquipage.toString()
            holder.nom.setOnClickListener{présentateur.requêteVoirDétailsÉquipage(position)}
        }

    }

    override fun getItemCount(): Int {
        return équipages?.size!!
    }

    inner class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){
        val nom: TextView = itemView.findViewById(R.id.tv_itemNomÉquipage)
        val doublons: TextView = itemView.findViewById(R.id.tv_itemTotalDoublon)
    }
}