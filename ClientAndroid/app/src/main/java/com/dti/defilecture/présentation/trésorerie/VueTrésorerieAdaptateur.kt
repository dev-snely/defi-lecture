package com.dti.defilecture.présentation.trésorerie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Équipage
import com.dti.defilecture.présentation.trésorerie.IContratVPTrésorerie.*

class VueTrésorerieAdaptateur(private val équipages : MutableList<Équipage>?) :
    RecyclerView.Adapter<VueTrésorerieAdaptateur.MyViewHolder>() {

    lateinit var context: Context
    lateinit var présentateur: IPrésentateurTrésorerie
    var vue = VueTrésorerie()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tresorerie,parent, false)
        context = parent.context
        présentateur = PrésentateurTrésorerie(vue)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = équipages?.get(position)
        if (currentItem != null){
            holder.nom.text = currentItem.nomÉquipage
            holder.doublons.text = currentItem.doublons.toString()
            holder.rang.text = currentItem.rang.toString()
            holder.nom.setOnClickListener{
                présentateur.requêteVoirDétailsÉquipage(holder.nom.text.toString())

            }
        }
    }

    override fun getItemCount(): Int {
        return équipages?.size!!
    }

    inner class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){
        val nom: TextView = itemView.findViewById(R.id.tv_itemNomÉquipage)
        val doublons: TextView = itemView.findViewById(R.id.tv_itemTotalDoublon)
        val rang: TextView = itemView.findViewById(R.id.tv_itemNuméroRang)
    }
}