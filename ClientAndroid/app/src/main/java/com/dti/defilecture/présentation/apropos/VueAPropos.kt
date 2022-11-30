package com.dti.defilecture.présentation.apropos

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
import com.dti.defilecture.présentation.apropos.IContratVPAPropos.IPrésentateurAPropos
import com.dti.defilecture.présentation.apropos.IContratVPAPropos.IVueAPropos

class VueAPropos: Fragment(), IVueAPropos {

    lateinit var navController : NavController
    lateinit var présentateur: IPrésentateurAPropos

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_apropos, container, false)
        présentateur = PrésentateurAPropos( this )
        return vue
    }
}