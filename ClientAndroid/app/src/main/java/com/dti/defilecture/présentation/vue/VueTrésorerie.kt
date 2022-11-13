package com.dti.defilecture.présentation.vue

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurTrésorerie
import com.dti.defilecture.présentation.modèle.modèle
import com.dti.defilecture.présentation.présentateur.PrésentateurTrésorerie


class VueTrésorerie : Fragment(), ContratVuePrésentateurTrésorerie.IVueTrésorerie  {

    lateinit var présentateur : ContratVuePrésentateurTrésorerie.IPrésentateurTrésorerie
    lateinit var searchView: SearchView
    lateinit var listeÉquipages: ListView
    lateinit var emptyText: TextView
    lateinit var adapter : ArrayAdapter<*>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_tresorerie, container, false)
        présentateur = PrésentateurTrésorerie( modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialisations
        searchView = view.findViewById(R.id.sv_équipage)
        listeÉquipages = view.findViewById(R.id.lv_listeÉquipages)
        emptyText = view.findViewById(R.id.tv_emptySearch)

        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.liste_équipages))
        listeÉquipages.adapter = adapter

        //Peu être modifier pour montrer/afficher l'équipage sélectionné
        listeÉquipages.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(context, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }
        listeÉquipages.emptyView = emptyText
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_equipage, menu)

        val search: MenuItem? = menu.findItem(R.id.search_equipage)
        val searchView: SearchView = search?.actionView as SearchView
        searchView.queryHint = "Recherche un équipage"

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu, inflater)
    }
}
