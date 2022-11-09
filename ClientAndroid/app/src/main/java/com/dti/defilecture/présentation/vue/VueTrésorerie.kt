package com.dti.defilecture.présentation.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurTrésorerie
import com.dti.defilecture.présentation.modèle.Modèle
import com.dti.defilecture.présentation.présentateur.PrésentateurTrésorerie


class VueTrésorerie : Fragment(), ContratVuePrésentateurTrésorerie.IVueTrésorerie  {

    lateinit var présentateur : ContratVuePrésentateurTrésorerie.IPrésentateurTrésorerie
    lateinit var listeÉquipages: ListView
    lateinit var emptyText: TextView
    lateinit var adapter : ArrayAdapter<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_tresorerie, container, false)
        présentateur = PrésentateurTrésorerie( Modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialisations
        listeÉquipages = view.findViewById(R.id.lv_listeÉquipages)
        emptyText = view.findViewById(R.id.tv_emptySearch)

        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.liste_équipages))
        listeÉquipages.adapter = adapter
        listeÉquipages.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(context, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }
        listeÉquipages.emptyView = emptyText

        //Différente fonctions sur la vue.
        rechercherUneÉquipe()

    }

    private fun rechercherUneÉquipe() {

    }
}