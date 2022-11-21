package com.dti.defilecture.présentation.ajouterlecture.temps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IPrésentateurAjouterLectureTemps
import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IVueAjouterLectureTemps


class VueAjouterLectureTemps : Fragment(), IVueAjouterLectureTemps {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurAjouterLectureTemps

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_vue_ajouter_lecture_temps, container, false)
        présentateur = PrésentateurAjouterLectureTemps( modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun naviguerVersAjouterLectureObligation() {
        navController.navigate(R.id.action_vueAjouterLectureTemps_to_vueAjouterLectureObligation)
    }

}