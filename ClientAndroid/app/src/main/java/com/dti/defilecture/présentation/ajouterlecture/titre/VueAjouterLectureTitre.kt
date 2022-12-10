package com.dti.defilecture.présentation.ajouterlecture.titre

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.ajouterlecture.titre.IContratVPAjouterLectureTitre.IPrésentateurAjouterLectureTitre
import com.dti.defilecture.présentation.ajouterlecture.titre.IContratVPAjouterLectureTitre.IVueAjouterLectureTitre

class VueAjouterLectureTitre : Fragment(), IVueAjouterLectureTitre {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurAjouterLectureTitre
    lateinit var btnSuivant: Button
    lateinit var tvTitreLecture: TextView
    lateinit var builder : AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var vue = inflater.inflate(R.layout.fragment_vue_ajouter_lecture_titre, container, false)
        présentateur = PrésentateurAjouterLectureTitre( this)
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        tvTitreLecture = view.findViewById(R.id.editTextAjouterTitreLecture)
        btnSuivant = view.findViewById(R.id.btnTerminerVersMesLectures)

        btnSuivant.setOnClickListener {
            présentateur.avertirInfosManquant(tvTitreLecture.text.toString())
            présentateur.traiterAjouterLectureTitre(
                tvTitreLecture.text.toString()
            )
        }
    }

    override fun naviguerVersAjouterTempsLecture() {
        navController.navigate(R.id.action_vueAjouterLectureTitre_to_vueAjouterLectureTemps)
    }

    override fun afficherAvertissementInfosManquants() {
        builder = AlertDialog.Builder(this.context)
        builder.setTitle(getString(R.string.avertissement))
            .setMessage(getString(R.string.titreManquant))
            .setCancelable(true)
            .setPositiveButton(getString(R.string.jaicompris)){dialoginterface, it ->
                //continue
            }
            .show()
    }
}