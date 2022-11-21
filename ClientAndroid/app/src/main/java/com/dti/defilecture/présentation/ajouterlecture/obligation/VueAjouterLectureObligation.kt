package com.dti.defilecture.présentation.ajouterlecture.obligation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.ajouterlecture.obligation.IContratVPAjouterLectureObligation.IPrésentateurAjouterLectureObligation
import com.dti.defilecture.présentation.ajouterlecture.obligation.IContratVPAjouterLectureObligation.IVueAjouterLectureObligation


class VueAjouterLectureObligation : Fragment(), IVueAjouterLectureObligation {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurAjouterLectureObligation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_vue_ajouter_lecture_obligation, container, false)
        présentateur = PrésentateurAjouterLectureObligation( modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun naviguerVersMesLecture() {
        navController.navigate(R.id.action_vueAjouterLectureObligation_to_vueMesLectures)
    }
}