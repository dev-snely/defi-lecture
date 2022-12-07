package com.dti.defilecture.présentation.trésorerie

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.trésorerie.IContratVPTrésorerie.*


class VueTrésorerie : Fragment(), IVueTrésorerie {

    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurTrésorerie
    lateinit var adaptateur: VueTrésorerieAdaptateur

    /**
    lateinit var listeÉquipages: ListView
    lateinit var emptyText: TextView*/
    lateinit var adapter : ArrayAdapter<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_tresorerie, container, false)
        présentateur = PrésentateurTrésorerie(this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_trésorerie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adaptateur = VueTrésorerieAdaptateur( présentateur.initisaliseurDesÉquipages(), présentateur )
        recyclerView.adapter = adaptateur
/**
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
        listeÉquipages.emptyView = emptyText */
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

    override fun naviguerVersDétailsÉquipage(position: Int) {
        val positionÉquipageUtilisateur = 0
        navController.navigate(R.id.action_vueTrésorerie_to_vueÉquipage)
        /**if (position == positionÉquipageUtilisateur) {
            navController.navigate(R.id.action_vueTrésorerie_to_vueÉquipage)
        }*/
    }
}
