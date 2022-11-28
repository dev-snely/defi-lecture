package com.dti.defilecture.présentation.équipage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.VueMesLecturesAdaptateur
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.IPrésentateurÉquipage
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.IVueÉquipage


class VueÉquipage : Fragment(), IVueÉquipage  {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurÉquipage
    lateinit var adaptateur: VueÉquipageAdaptateur

    lateinit var nomÉquipage: TextView
    lateinit var numéroRang: TextView
    lateinit var totalDoublons: TextView
    lateinit var listeComptesÉquipage: ListView
    lateinit var adapter : ArrayAdapter<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_equipage, container, false)
        présentateur = PrésentateurÉquipage( modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        lateinit var recyclerView: RecyclerView

        nomÉquipage = view.findViewById(R.id.tv_nomÉquipage)
        numéroRang = view.findViewById(R.id.tv_numéroRang)
        totalDoublons = view.findViewById(R.id.tv_totalDoublons)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_Équipage)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adaptateur = VueÉquipageAdaptateur( présentateur.initisaliseurDesComptes() )
        recyclerView.adapter = adaptateur

/**
        listeComptesÉquipage = view.findViewById(R.)

        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.liste_personnes))
        listeComptesÉquipage.adapter = adapter
        listeComptesÉquipage.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(context, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }*/

        //Différentes fonctions sur la vue.
        calculerTotalDoublons()
    }

    private fun calculerTotalDoublons() {
        totalDoublons.text = (0).toString() + " doublons"
    }

    override fun naviguerVersUnCompte() {
        navController.navigate(R.id.action_vueÉquipage_to_vueCompteUtilisateur)
    }
}