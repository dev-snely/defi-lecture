package com.dti.defilecture.présentation.ajouterlecture.titre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.ajouterlecture.titre.IContratVPAjouterLectureTitre.IPrésentateurAjouterLectureTitre
import com.dti.defilecture.présentation.ajouterlecture.titre.IContratVPAjouterLectureTitre.IVueAjouterLectureTitre
import com.dti.defilecture.présentation.modèle

class VueAjouterLectureTitre : Fragment(), IVueAjouterLectureTitre {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurAjouterLectureTitre

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vue = inflater.inflate(R.layout.fragment_vue_ajouter_lecture_titre, container, false)
        présentateur = PrésentateurAjouterLectureTitre( modèle, this)
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun naviguerVersAjouterTempsLecture() {
        navController.navigate(R.id.action_vueAjouterLectureTitre_to_vueAjouterLectureTemps)
    }


}