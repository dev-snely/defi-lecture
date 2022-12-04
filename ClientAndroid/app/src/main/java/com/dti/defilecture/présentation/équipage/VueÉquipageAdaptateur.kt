package com.dti.defilecture.présentation.équipage


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.*

class VueÉquipageAdaptateur(private val comptes: MutableList<Compte>?) :
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
            holder.pseudonyme.text = currentItem.pseudonyme
            holder.doublons.text = currentItem.doublons.toString()
            holder.delete.setOnClickListener(){
                val builder = AlertDialog.Builder(context)
                builder.setMessage("Êtes-vous certain d'effacer ce compte de l'équipage?")
                builder.setPositiveButton("Yes", {dialog, id ->})
                builder.setNegativeButton("No", {dialog, id ->})
                builder.create().show()
            }
        }
    }

    override fun getItemCount(): Int {
        return comptes?.size!!
    }

    inner class MyViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView){
        val pseudonyme: TextView = itemView.findViewById(R.id.tv_itemPseudonyme)
        val doublons: TextView = itemView.findViewById(R.id.tv_itemCompteTotalDoublon)
        val delete: ImageButton = itemView.findViewById(R.id.deleteEquipage)
    }
}