package com.dti.defilecture.présentation.menu

import android.widget.Button
import com.dti.defilecture.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.dti.defilecture.présentation.menu.IContratVPMenu.IPrésentateurMenu
import com.dti.defilecture.présentation.menu.IContratVPMenu.IVueMenu

class VueMenu: Fragment(), IVueMenu {

    lateinit var navController : NavController
    lateinit var présentateur: IPrésentateurMenu

    lateinit var btnLangage : Button
    lateinit var btnGlossaire : Button
    lateinit var btnAPropos: Button
    lateinit var btnDeconnexion: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_menu, container, false)
        présentateur = PrésentateurMenu( this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnLangage = view.findViewById(R.id.btnLangage)
        btnGlossaire = view.findViewById(R.id.btnGlossaire)
        btnAPropos = view.findViewById(R.id.btnAPropos)
        btnDeconnexion = view.findViewById(R.id.btnDeconnexion)

        btnLangage.setOnClickListener {
            naviguerVersPageLangage()
        }

        btnGlossaire.setOnClickListener {
            naviguerVersPageGlossaire()
        }

        btnAPropos.setOnClickListener {
            naviguerVersPageAPropos()
        }

        btnDeconnexion.setOnClickListener {
            deconnexion()
        }
    }

        override fun naviguerVersPageLangage(){
            navController.navigate(R.id.action_vueMenu_to_vueLangage)
        }

        override fun naviguerVersPageGlossaire(){
            navController.navigate(R.id.action_vueMenu_to_vueGlossaire)
        }

        override fun naviguerVersPageAPropos(){
            navController.navigate(R.id.action_vueMenu_to_vueAPropos)
        }

        override fun deconnexion() {
            navController.navigate(R.id.action_vueMenu_to_connexionActivity)
        }

}