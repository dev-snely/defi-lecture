package com.dti.defilecture.présentation.équipageTemporaire

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
import com.dti.defilecture.présentation.équipageTemporaire.IContratVPÉquipageTemporaire.*


class VueÉquipageTemporaire : Fragment(), IVueÉquipageTemporaire  {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurÉquipageTemporaire
    lateinit var adaptateur: VueÉquipageTemporaireAdaptateur

    lateinit var nomÉquipageTemporaire: TextView
    lateinit var numéroRangTemporaire: TextView
    lateinit var totalDoublonsTemporaire: TextView

    val équipageTemporaire = modèle.équipage()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_equipage_temporaire, container, false)
        présentateur = PrésentateurÉquipageTemporaire( this  )

        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        nomÉquipageTemporaire = view.findViewById(R.id.tv_nomÉquipageTemporaire)
        numéroRangTemporaire = view.findViewById(R.id.tv_numéroRangTemporaire)
        totalDoublonsTemporaire = view.findViewById(R.id.tv_totalDoublonsTemporaire)

        nomÉquipageTemporaire.text = équipageTemporaire.nomÉquipage
        numéroRangTemporaire.text = équipageTemporaire.rang.toString()
        totalDoublonsTemporaire.text = équipageTemporaire.doublonsÉquipage.toString()

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_équipageTemporaire)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adaptateur = VueÉquipageTemporaireAdaptateur( présentateur.initisaliseurDesComptesTemporaires(nomÉquipageTemporaire.text.toString()), présentateur)
        recyclerView.adapter = adaptateur

        //Différentes fonctions sur la vue.
        calculerTotalDoublons()
    }

    private fun calculerTotalDoublons() {
        totalDoublonsTemporaire.text = (0).toString() + " doublons"
    }

    override fun naviguerVersDétailsCompteTemporaire() {
       navController.navigate(R.id.action_vueÉquipageTemporaire_to_vueCompteTemporaire)
    }
}