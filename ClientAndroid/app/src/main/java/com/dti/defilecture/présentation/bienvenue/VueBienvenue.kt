package com.dti.defilecture.présentation.bienvenue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.bienvenue.IContratVPBienvenue.IVueBienvenue
import com.dti.defilecture.présentation.bienvenue.IContratVPBienvenue.IPrésentateurBienvenue

class VueBienvenue: Fragment(), IVueBienvenue {

    lateinit var navController : NavController
    lateinit var présentateur: IPrésentateurBienvenue

    lateinit var btnConnexion : Button
    lateinit var btnInscription : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_page_de_bienvenue, container, false)
        présentateur = PrésentateurBienvenue( this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnInscription = view.findViewById(R.id.btnInscription)
        btnConnexion = view.findViewById(R.id.btnConnexion)

        btnInscription.setOnClickListener {
            naviguerVersInscription()
        }

        btnConnexion.setOnClickListener {
            naviguerVersConnexion()
        }
    }

    override fun naviguerVersInscription(){
        navController.navigate(R.id.action_vueBienvenue_to_vueInscription)
    }

    override fun naviguerVersConnexion(){
        navController.navigate(R.id.action_vueBienvenue_to_vueConnexion)
    }
}