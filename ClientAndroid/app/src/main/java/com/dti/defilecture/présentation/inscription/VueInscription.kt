package com.dti.defilecture.présentation.inscription

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.dti.defilecture.R
import com.dti.defilecture.présentation.inscription.ContratVuePrésentateurInscription.IVueInscription
import com.dti.defilecture.présentation.inscription.ContratVuePrésentateurInscription.IPrésentateurInscription
import com.dti.defilecture.présentation.présentateur.PrésentateurInscription


class VueInscription : Fragment(), IVueInscription {

    lateinit var présentateur: IPrésentateurInscription
    lateinit var btnInscription: Button
    lateinit var tvNom: TextView
    lateinit var tvPrenom: TextView
    lateinit var tvCourriel: TextView
    lateinit var tvProgramme: TextView
    lateinit var tvPseudonyme: TextView
    lateinit var tvMotDePasse: TextView
    lateinit var tvConfirmationMotDePasse: TextView

    private lateinit var builder : AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_inscription, container, false)
        présentateur = PrésentateurInscription( this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnInscription = view.findViewById(R.id.btnModifier)
        tvNom = view.findViewById(R.id.tvNom)
        tvPrenom = view.findViewById(R.id.tvPrenom)
        tvCourriel = view.findViewById(R.id.tvCourriel)
        tvProgramme = view.findViewById(R.id.tvProgramme)
        tvPseudonyme = view.findViewById(R.id.tvPseudonyme)
        tvMotDePasse = view.findViewById(R.id.tvPassword)
        tvConfirmationMotDePasse = view.findViewById(R.id.tvValidPassword)

        gestionCréationInscription()

    }

    override fun afficherAvertissementInfosManquants(message: String) {
        builder = AlertDialog.Builder(context)
        builder.setTitle("Avertissement!")
            .setMessage(message)
            .setCancelable(true)
            .setPositiveButton("J'ai compris"){ _, _ ->

            }.show()
    }

    private fun gestionCréationInscription(){
        btnInscription.setOnClickListener {
            présentateur.verifierInfosManquant(tvPrenom.text.toString(),tvNom.text.toString(),
                tvCourriel.text.toString(),tvPseudonyme.text.toString(),tvProgramme.text.toString(),
                tvMotDePasse.text.toString(), tvConfirmationMotDePasse.text.toString())
        }
    }
}