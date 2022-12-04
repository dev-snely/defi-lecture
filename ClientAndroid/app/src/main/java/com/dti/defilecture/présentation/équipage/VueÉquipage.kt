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
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.*


class VueÉquipage : Fragment(), IVueÉquipage  {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurÉquipage
    lateinit var adaptateur: VueÉquipageAdaptateur

    lateinit var nomÉquipage: TextView
    lateinit var numéroRang: TextView
    lateinit var totalDoublons: TextView
    /**lateinit var listeComptesÉquipage: ListView
    lateinit var adapter : ArrayAdapter<*>*/

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

        nomÉquipage = view.findViewById(R.id.tv_nomÉquipage)
        numéroRang = view.findViewById(R.id.tv_numéroRang)
        totalDoublons = view.findViewById(R.id.tv_totalDoublons)

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_Équipage)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adaptateur = VueÉquipageAdaptateur( présentateur.initisaliseurDesComptes())
        recyclerView.adapter = adaptateur

        //Différentes fonctions sur la vue.
        calculerTotalDoublons()
    }

    private fun calculerTotalDoublons() {
        totalDoublons.text = (0).toString() + " doublons"
    }
}