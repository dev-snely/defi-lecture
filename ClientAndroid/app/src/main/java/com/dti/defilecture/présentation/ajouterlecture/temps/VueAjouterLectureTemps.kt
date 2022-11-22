package com.dti.defilecture.présentation.ajouterlecture.temps

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IPrésentateurAjouterLectureTemps
import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IVueAjouterLectureTemps


class VueAjouterLectureTemps : Fragment(), IVueAjouterLectureTemps {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurAjouterLectureTemps
    lateinit var tvNbMinutes: TextView
    lateinit var btn15mins: Button
    lateinit var btn30mins: Button
    lateinit var btn45mins: Button
    lateinit var btn60mins: Button
    lateinit var btnReinit: ImageButton
    lateinit var btnSuivant: Button
    lateinit var builder : AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_vue_ajouter_lecture_temps, container, false)
        présentateur = PrésentateurAjouterLectureTemps( this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnSuivant = view.findViewById(R.id.btnTerminerVersMesLectures)
        tvNbMinutes = view.findViewById(R.id.descriptionAjouterTemps)
        btn15mins = view.findViewById(R.id.btn15minutes)
        btn30mins = view.findViewById(R.id.btn30minutes)
        btn45mins = view.findViewById(R.id.btn45minutes)
        btn60mins = view.findViewById(R.id.btn60minutes)
        btnReinit = view.findViewById(R.id.VALTBtnReinit)

        btnSuivant.setOnClickListener {
            présentateur.avertirInfosManquant(
                tvNbMinutes
                    .text.toString()
                    .filter { it.isDigit() }
                    .toInt()
            )
        }

        btn15mins.setOnClickListener{
            présentateur.traiterAjouterMinutes(15, tvNbMinutes.text.toString())
        }
        btn30mins.setOnClickListener{
            présentateur.traiterAjouterMinutes(30, tvNbMinutes.text.toString())
        }
        btn45mins.setOnClickListener{
            présentateur.traiterAjouterMinutes(45, tvNbMinutes.text.toString())
        }
        btn60mins.setOnClickListener{
            présentateur.traiterAjouterMinutes(60, tvNbMinutes.text.toString())
        }


    }

    override fun naviguerVersAjouterLectureObligation() {
        navController.navigate(R.id.action_vueAjouterLectureTemps_to_vueAjouterLectureObligation)
    }

    override fun modifierMinutesAuCompteur(nombreDeMinutes: Int) {
        if (nombreDeMinutes != 0){
            tvNbMinutes.text = getString(R.string.minutes_pluriel, nombreDeMinutes)
        } else {
            tvNbMinutes.text = getString(R.string.minutes_singulier)
        }
    }

    override fun réinitialiserMinutesAuCompteur() {
        tvNbMinutes.text = getString(R.string.minutes_singulier)
    }
    override fun afficherAvertissementInfosManquants(message: String) {
        builder = AlertDialog.Builder(this.context)
        builder.setTitle(getString(R.string.avertissement))
            .setMessage(message)
            .setCancelable(true)
            .setPositiveButton(getString(R.string.jaicompris)){dialoginterface, it ->
                //continue l'application
            }
            .show()
    }

}