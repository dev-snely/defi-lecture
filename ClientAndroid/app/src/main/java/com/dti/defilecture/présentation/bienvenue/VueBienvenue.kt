package com.dti.defilecture.présentation.bienvenue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.bienvenue.IContratVPBienvenue.IVueBienvenue
import com.dti.defilecture.présentation.bienvenue.IContratVPBienvenue.IPrésentateurBienvenue


class VueBienvenue: Fragment(), IVueBienvenue {

    lateinit var présentateur: IPrésentateurBienvenue

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_page_de_bienvenue, container, false)
        présentateur = PrésentateurBienvenue( this )
        return vue
    }


}