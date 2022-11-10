package com.dti.defilecture.présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dti.defilecture.R

class VueBarreNavigation : Fragment() {

    private lateinit var iconeAjouter: View
    private lateinit var iconeEquipage: View
    private lateinit var iconeTresorerie: View
    private lateinit var iconeEpreuve: View
    private lateinit var iconeCompte: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue =  inflater.inflate(R.layout.fragment_vue_barre_navigation, container, false)
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iconeAjouter = view.findViewById(R.id.ic_ajouter)
        iconeEquipage = view.findViewById(R.id.ic_equipage)
        iconeTresorerie = view.findViewById(R.id.ic_tresorerie)
        iconeEpreuve = view.findViewById(R.id.ic_epreuve)
        iconeCompte = view.findViewById(R.id.ic_compte)

        afficherProchainFragment()

    }


    /** Fonction qui affiche le fragment selon le bouton dans la barre de navigation
     *
     */
    private fun afficherProchainFragment() {
        iconeAjouter.setOnClickListener{

        }
    }

}