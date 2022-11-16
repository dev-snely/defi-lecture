package com.dti.defilecture.présentation.inscription

import android.app.AlertDialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.dti.defilecture.R
import com.dti.defilecture.présentation.modèle


class VueInscription : Fragment(), ContratVuePrésentateurInscription.IVueInscription {

    lateinit var présentateur: ContratVuePrésentateurInscription.IPrésentateurInscription
    lateinit var btnInscription: Button
    lateinit var tvNom: TextView
    lateinit var tvPrenom: TextView
    lateinit var tvCourriel: TextView
    lateinit var tvProgramme: TextView
    lateinit var tvPseudonyme: TextView
    lateinit var tvMotDePasse: TextView
    lateinit var tvConfirmationMotDePasse: TextView

    private lateinit var builder : AlertDialog.Builder

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_inscription, container, false)
        présentateur = PrésentateurInscription( modèle, this  )
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

    override fun afficherAvertissementInfosManquants(message: String) {
        builder = AlertDialog.Builder(this.context)
        builder.setTitle("Avertissement!")
            .setMessage(message)
            .setCancelable(true)
            .setPositiveButton("J'ai compris"){dialoginterface, it ->
                //continue l'application
            }
        .show()
    }

    private fun gestionCréationInscription(){
        btnInscription.setOnClickListener {
            présentateur.verifierInfosManquant(tvPrenom.text.toString(),tvNom.text.toString(),
                tvCourriel.text.toString(),tvPseudonyme.text.toString(),tvProgramme.text.toString(),
                tvMotDePasse.text.toString(), tvConfirmationMotDePasse.text.toString())


        }
    }


}