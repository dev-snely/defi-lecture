package com.dti.defilecture.présentation.équipage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.*

class VueÉquipageAdaptateur(
    private val comptes: MutableList<Compte>?,
    var présentateur: IPrésentateurÉquipage) : RecyclerView.Adapter<VueÉquipageAdaptateur.MyViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_equipage, parent, false)

        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = comptes?.get(position)
        if (currentItem != null){
            holder.pseudonyme.text = currentItem.pseudonyme
            holder.doublons.text = currentItem.doublons.toString()
            holder.pseudonyme.setOnClickListener{présentateur
                .requêteVoirDétailsCompte(holder.pseudonyme.text.toString(), modèle.équipage().nomÉquipage)}
        }
    }

    override fun getItemCount(): Int {
        return comptes?.size!!
    }

    inner class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){
        val pseudonyme: TextView = itemView.findViewById(R.id.tv_itemPseudonyme)
        val doublons: TextView = itemView.findViewById(R.id.tv_itemCompteTotalDoublon)
    }
}