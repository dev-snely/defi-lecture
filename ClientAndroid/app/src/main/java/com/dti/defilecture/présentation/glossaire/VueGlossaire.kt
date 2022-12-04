package com.dti.defilecture.présentation.glossaire

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
import com.dti.defilecture.présentation.glossaire.IContratVPGlossaire.IPrésentateurGlossaire
import com.dti.defilecture.présentation.glossaire.IContratVPGlossaire.IVueGlossaire

class VueGlossaire: Fragment(), IVueGlossaire {

    lateinit var navController : NavController
    lateinit var présentateur: IPrésentateurGlossaire

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_glossaire, container, false)
        présentateur = PrésentateurGlossaire( this )
        return vue
    }
}