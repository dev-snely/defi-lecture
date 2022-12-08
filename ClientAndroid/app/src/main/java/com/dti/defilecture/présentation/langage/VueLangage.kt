package com.dti.defilecture.présentation.langage

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
import com.dti.defilecture.présentation.langage.IContratVPLangage.IPrésentateurLangage
import com.dti.defilecture.présentation.langage.IContratVPLangage.IVueLangage

class VueLangage: Fragment(), IVueLangage {

    lateinit var navController : NavController
    lateinit var présentateur: IPrésentateurLangage
    lateinit var btnFrançais: Button
    lateinit var btnEnglish: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_langage, container, false)
        présentateur = PrésentateurLangage( this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        /*btnFrançais.setOnClickListener {

        }
        btnEnglish.setOnClickListener {

        }*/

    }

}