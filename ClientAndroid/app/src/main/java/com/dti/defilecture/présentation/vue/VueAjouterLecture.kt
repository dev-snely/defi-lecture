package com.dti.defilecture.présentation.vue

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurAjouterLecture
import com.dti.defilecture.présentation.modèle.Modèle
import com.dti.defilecture.présentation.présentateur.PrésentateurAjouterLecture


class VueAjouterLecture : Fragment(), ContratVuePrésentateurAjouterLecture.IVueAjouterLecture  {

    lateinit var présentateur : ContratVuePrésentateurAjouterLecture.IPrésentateurAjouterLecture
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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_ajouter_lecture, container, false)
        présentateur = PrésentateurAjouterLecture( Modèle, this  )
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
        btnAjouterLecture.isClickable = false
        btnAjouterLecture.setBackgroundColor(Color.GRAY)

        //Différente fonctions sur la vue.
        gestionAjoutMinutes()
        gestionObligationLecture()
        gestionBtnReinit()
        gestionAjoutLecture()

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

    private fun gestionObligationLecture(){
        rdBtnOui.setOnClickListener {
            présentateur.traiterObligationDeLecture()
        }
        rdBtnNon.setOnClickListener {
            présentateur.traiterObligationDeLecture()
        }
    }

    private fun gestionBtnReinit(){
        btnReinit.setOnClickListener {
            présentateur.traiterReinitialisationCompteur()
        }
    }
    private fun gestionAjoutLecture(){

    }

    override fun modifierMinutesAuCompteur(nombreDeMinutes: Int) {
        tvNbMinutes.text = "$nombreDeMinutes minutes"
    }

    override fun réinitialiserMinutesAuCompteur() {
        tvNbMinutes.text = "0 minute"
    }

    override fun activerBoutonLorsqueLectureValide() {
        btnAjouterLecture.isClickable= true
        btnAjouterLecture.setBackgroundColor(resources.getColor(R.color.df_rougeprimaire))
    }

    override fun désactiverBoutonLorsqueLectureInvalide() {
        btnAjouterLecture.isClickable= false
        btnAjouterLecture.setBackgroundColor(Color.GRAY)
    }

    override fun afficherObligationDeLecture() {
        val selectBtn: Int= rdGroup!!.checkedRadioButtonId
        val btn = view?.findViewById<RadioButton>(selectBtn)
    }
}