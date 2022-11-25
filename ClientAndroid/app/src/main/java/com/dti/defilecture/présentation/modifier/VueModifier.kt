package com.dti.defilecture.présentation.modifier

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
import com.dti.defilecture.présentation.compte.IContratVPModifer.IPrésentateurModifer
import com.dti.defilecture.présentation.compte.IContratVPModifer.IVueModifer

class VueModifier : Fragment(), IVueModifer{

    lateinit var présentateur: IPrésentateurModifer
    lateinit var navController : NavController
    lateinit var btnEnregistrer : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_modification, container, false)
        présentateur = PrésentateurModifier( this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnEnregistrer = view.findViewById(R.id.btnModifier)

        btnEnregistrer.setOnClickListener {
            Log.d("Test", "Rediretion vers Mon Compte.")
            naviguerVersMonCompte()
        }
    }


    override fun naviguerVersMonCompte() {
        navController.navigate(R.id.action_vueModifier_to_vueCompteUtilisateur)
    }


}