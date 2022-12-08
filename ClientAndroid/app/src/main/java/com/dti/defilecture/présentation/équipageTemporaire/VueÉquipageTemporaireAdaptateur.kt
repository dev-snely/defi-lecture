package com.dti.defilecture.présentation.équipageTemporaire


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.équipageTemporaire.IContratVPÉquipageTemporaire.*

class VueÉquipageTemporaireAdaptateur(private val comptes: MutableList<Compte>?, var présentateur: IPrésentateurÉquipageTemporaire) :
    RecyclerView.Adapter<VueÉquipageTemporaireAdaptateur.MyViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_equipage_temporaire
        ,parent, false)
        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = comptes?.get(position)
        if (currentItem != null){
            holder.pseudonymeTemporaire.text = currentItem.pseudonyme
            holder.doublonsTemporaire.text = currentItem.doublons.toString()
            holder.pseudonymeTemporaire.setOnClickListener{présentateur.requêteVoirDétailsCompteTemporaire(holder.pseudonymeTemporaire.text.toString(), modèle.équipage().nomÉquipage)}
        }
    }

    override fun getItemCount(): Int {
        return comptes?.size!!
    }

    inner class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){
        val pseudonymeTemporaire: TextView = itemView.findViewById(R.id.tv_itemPseudonymeTemporaire)
        val doublonsTemporaire: TextView = itemView.findViewById(R.id.tv_itemCompteTotalDoublonTemporaire)
    }
}