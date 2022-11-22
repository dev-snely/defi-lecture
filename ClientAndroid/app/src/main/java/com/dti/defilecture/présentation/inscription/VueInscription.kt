package com.dti.defilecture.présentation.inscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.dti.defilecture.R
import com.dti.defilecture.présentation.inscription.ContratVuePrésentateurInscription.IVueInscription

class VueInscription : Fragment(), IVueInscription {

    lateinit var présentateur: ContratVuePrésentateurInscription.IPrésentateurInscription
    lateinit var btnInscription: Button
    lateinit var tvNom: TextView
    lateinit var tvPrenom: TextView
    lateinit var tvCourriel: TextView
    lateinit var tvProgramme: TextView
    lateinit var tvPseudonyme: TextView
    lateinit var tvMotDePasse: TextView
    lateinit var tvConfirmationMotDePasse: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_inscription, container, false)
        présentateur = PrésentateurInscription(  this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnInscription = view.findViewById(R.id.btnInscription)
        tvNom = view.findViewById(R.id.tvNom)
        tvPrenom = view.findViewById(R.id.tvPrenom)
        tvCourriel = view.findViewById(R.id.tvCourriel)
        tvProgramme = view.findViewById(R.id.tvProgramme)
        tvPseudonyme = view.findViewById(R.id.tvPseudonyme)
        tvMotDePasse = view.findViewById(R.id.tvPassword)
        tvConfirmationMotDePasse = view.findViewById(R.id.tvValidPassword)


    }


}