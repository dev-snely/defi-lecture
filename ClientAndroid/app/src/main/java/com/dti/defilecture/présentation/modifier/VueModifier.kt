package com.dti.defilecture.présentation.modifier

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.Modèle
import com.dti.defilecture.présentation.modifier.IContratVPModifier.IPrésentateurModifer
import com.dti.defilecture.présentation.modifier.IContratVPModifier.IVueModifer
import com.dti.defilecture.présentation.modèle

class VueModifier : Fragment(), IVueModifer{

    lateinit var présentateur: IPrésentateurModifer
    lateinit var navController : NavController
    lateinit var btnEnregistrer : Button
    lateinit var tvPseudonyme: EditText
    lateinit var tvPrénom: EditText
    lateinit var tvNom: EditText
    lateinit var tvCourriel: EditText
    lateinit var tvProgramme: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_modification, container, false)
        présentateur = PrésentateurModifier( modèle,this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        btnEnregistrer = view.findViewById(R.id.btnModifier)
        tvPseudonyme = view.findViewById(R.id.tvPseudonyme)
        tvPrénom = view.findViewById(R.id.tvPrenom)
        tvNom = view.findViewById(R.id.tvNom)
        tvCourriel = view.findViewById(R.id.tvCourriel)
        tvProgramme = view.findViewById(R.id.tvProgramme)

        présentateur.requêteInitialiserCompte()

        btnEnregistrer.setOnClickListener {
            présentateur.enregistrerInfo(tvPseudonyme.text.toString(),tvPrénom.text.toString(),
                tvNom.text.toString(),tvCourriel.text.toString(),tvProgramme.text.toString())
            naviguerVersMonCompte()
        }

    }

    override fun initModifier(pseudonyme:String, nom: String, prénom: String,
                            courriel: String, programme: String) {
        tvPseudonyme.setText(pseudonyme)
        tvPrénom.setText(prénom)
        tvNom.setText(nom)
        tvCourriel.setText(courriel)
        tvProgramme.setText(programme)

    }


    override fun naviguerVersMonCompte() {
        navController.navigate(R.id.action_vueModifier_to_vueCompteUtilisateur)
    }


}