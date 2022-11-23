package com.dti.defilecture.présentation.ajouterlecture.obligation

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.ajouterlecture.obligation.IContratVPAjouterLectureObligation.IPrésentateurAjouterLectureObligation
import com.dti.defilecture.présentation.ajouterlecture.obligation.IContratVPAjouterLectureObligation.IVueAjouterLectureObligation


class VueAjouterLectureObligation : Fragment(), IVueAjouterLectureObligation {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurAjouterLectureObligation
    lateinit var btnSuivant: Button
    lateinit var builder : AlertDialog.Builder
    lateinit var rdGroup: RadioGroup
    lateinit var rdBtnOui: RadioButton
    lateinit var rdBtnNon: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_vue_ajouter_lecture_obligation, container, false)
        présentateur = PrésentateurAjouterLectureObligation(  this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnSuivant = view.findViewById(R.id.btnTerminerVersMesLectures)

        rdGroup = view.findViewById(R.id.rg_VALO)
        rdBtnOui = view.findViewById(R.id.rb_option_oui)
        rdBtnNon = view.findViewById(R.id.rb_option_non)

        btnSuivant.setOnClickListener {
            présentateur.avertirInfoManquante( rdBtnOui.isChecked || rdBtnNon.isChecked )
            présentateur.traiterObligationDeLecture(
                rdBtnOui.isChecked || rdBtnNon.isChecked,
                rdBtnOui.isChecked,
                rdBtnNon.isChecked
            )
            présentateur.ajouterLectureDansLaSource()
            présentateur.naviguerVersMesLecture()
        }
    }

    override fun naviguerVersMesLecture() {
        navController.navigate(R.id.action_vueAjouterLectureObligation_to_vueMesLectures)
    }

    override fun afficherAvertissementInfosManquants() {
        builder = AlertDialog.Builder(this.context)
        builder.setTitle(getString(R.string.avertissement))
            .setMessage(getString(R.string.obligationManquant))
            .setCancelable(true)
            .setPositiveButton(getString(R.string.jaicompris)){dialoginterface, it ->
                //continue l'application
            }
            .show()
    }

    override fun avertirAjoutReussi() {
        Toast.makeText(this.context,"Lecture Ajouté!",Toast.LENGTH_SHORT)
    }
}