package com.dti.defilecture.présentation.ajouterlecture

import android.app.AlertDialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.ajouterlecture.ContratVuePrésentateurAjouterLecture.IPrésentateurAjouterLecture
import com.dti.defilecture.présentation.ajouterlecture.ContratVuePrésentateurAjouterLecture.IVueAjouterLecture


class VueAjouterLecture : Fragment(), IVueAjouterLecture  {

    lateinit var présentateur : IPrésentateurAjouterLecture
    lateinit var btn15mins: Button
    lateinit var btn30mins: Button
    lateinit var btn45mins: Button
    lateinit var btn60mins: Button
    lateinit var btnReinit: Button
    lateinit var btnAjouterLecture: Button
    lateinit var rdGroup: RadioGroup
    lateinit var rdBtnOui: RadioButton
    lateinit var rdBtnNon: RadioButton
    lateinit var tvTitreLecture: TextView
    lateinit var tvNbMinutes: TextView

    private lateinit var builder : AlertDialog.Builder


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_ajouter_lecture, container, false)
        présentateur = PrésentateurAjouterLecture( modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialisations
        tvNbMinutes = view.findViewById(R.id.tvNbMins)
        tvTitreLecture = view.findViewById(R.id.LectureEditTxt)
        btn15mins = view.findViewById(R.id.btn15minutes)
        btn30mins = view.findViewById(R.id.btn30minutes)
        btn45mins = view.findViewById(R.id.btn45minutes)
        btn60mins = view.findViewById(R.id.btn60minutes)
        btnReinit = view.findViewById(R.id.btnReinit)
        rdGroup = view.findViewById(R.id.radioGroup)
        rdBtnOui = view.findViewById(R.id.radio_oui)
        rdBtnNon = view.findViewById(R.id.radio_non)
        btnAjouterLecture = view.findViewById(R.id.btnAjouterLecture)
        //

        //Différente fonctions sur la vue.
        gestionAjoutMinutes()
        gestionBtnReinit()
        gestionAjoutLecture()
        gestionValidation()
        gestionObligationLecture()
    }

    private fun gestionAjoutMinutes(){
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

    private fun gestionBtnReinit(){
        btnReinit.setOnClickListener {
            présentateur.traiterReinitialisationCompteur()
        }
    }
    private fun gestionAjoutLecture(){
        //btnAjouterLecture.setBackgroundColor(Color.GRAY)
        var bool: Boolean = false
        if(rdGroup.checkedRadioButtonId == rdBtnNon.id) { bool = false }
        else if (rdGroup.checkedRadioButtonId == rdBtnOui.id) { bool = true }
        /*

        Changement couleur du bouton ajouter lecture
        ------------------------------------------------
        btnAjouterLecture.setOnClickListener {
            if ( tvTitreLecture.text.toString().isNotEmpty() &&
                tvNbMinutes.text.toString().filter { it.isDigit() }.toInt() != 0 &&
                rdBtnOui.isChecked || rdBtnNon.isChecked ){

                btnAjouterLecture.setBackgroundColor(Color.BLUE)

            }
        }
*/
        btnAjouterLecture.setOnClickListener {
            présentateur.traiterAjouterLecture(
                tvTitreLecture.text.toString(),
                tvNbMinutes
                    .text.toString()
                    .filter { it.isDigit() }
                    .toInt(),
                rdBtnOui.isChecked || rdBtnNon.isChecked,
                bool
            )
        }
    }

    private fun gestionValidation(){
        btnAjouterLecture.setOnClickListener {
            présentateur.avertirInfosManquant(
                tvTitreLecture.text.toString(),
                tvNbMinutes
                    .text.toString()
                    .filter { it.isDigit() }
                    .toInt(),
                rdBtnOui.isChecked || rdBtnNon.isChecked
            )
        }
    }
    private fun gestionObligationLecture(){
        rdBtnOui.setOnClickListener {
            présentateur.traiterObligationDeLecture()
        }
        rdBtnNon.setOnClickListener {
            présentateur.traiterObligationDeLecture()
        }
    }

    override fun afficherObligationDeLecture() {
        val selectBtn: Int= rdGroup!!.checkedRadioButtonId
        val btn = view?.findViewById<RadioButton>(selectBtn)
    }


    override fun modifierMinutesAuCompteur(nombreDeMinutes: Int) {
        tvNbMinutes.text = "$nombreDeMinutes minutes"
    }

    override fun réinitialiserMinutesAuCompteur() {
        tvNbMinutes.text = "0 minute"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun activerBoutonLorsqueLectureValide() {
        this.context?.let { btnAjouterLecture.setBackgroundColor(it.getColor(R.color.df_rougeprimaire)) }
    }

    override fun désactiverBoutonLorsqueLectureInvalide() {
        btnAjouterLecture.setBackgroundColor(Color.GRAY)
    }

    override fun afficherAvertissementInfosManquants(message: String) {
        builder = AlertDialog.Builder(this.context)
        builder.setTitle("Avertissement!")
            .setMessage(message)
            .setCancelable(true)
            .setPositiveButton("J'ai compris"){dialoginterface, it ->
                //continue l'application
            }
            .show()
        désactiverBoutonLorsqueLectureInvalide()
    }

    override fun avertirAjoutReussi(message: String) {
        builder = AlertDialog.Builder(this.context)
        builder.setTitle("Réussi!")
            .setMessage(message)
            .setCancelable(true)
            .setPositiveButton("J'ai compris"){dialoginterface, it ->
                //continue l'application
            }
    }


}