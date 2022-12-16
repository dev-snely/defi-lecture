package com.dti.defilecture.présentation.équipageTemporaire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.équipageTemporaire.IContratVPÉquipageTemporaire.*


class VueÉquipageTemporaire : Fragment(), IVueÉquipageTemporaire  {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurÉquipageTemporaire
    lateinit var adaptateur: VueÉquipageTemporaireAdaptateur

    lateinit var nomÉquipageTemporaire: TextView
    lateinit var numéroRangTemporaire: TextView
    lateinit var totalDoublonsTemporaire: TextView
    lateinit var rejoindreÉquipage: ImageButton

    lateinit var comptes: MutableList<Compte>
    lateinit var recyclerView: RecyclerView

    val équipageTemporaire = modèle.initialiserÉquipage(modèle.compteTemporaire().nomÉquipage)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_equipage_temporaire, container, false)
        présentateur = PrésentateurÉquipageTemporaire( this  )

        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        nomÉquipageTemporaire = view.findViewById(R.id.tv_nomÉquipageTemporaire)
        numéroRangTemporaire = view.findViewById(R.id.tv_numéroRangTemporaire)
        totalDoublonsTemporaire = view.findViewById(R.id.tv_totalDoublonsTemporaire)
        rejoindreÉquipage = view.findViewById(R.id.ib_rejoindreÉquipage)

        nomÉquipageTemporaire.text = équipageTemporaire.nomÉquipage
        afficherTotalDoublons()
        afficherRang()
        //rejoindreÉquipage.setOnClickListener { présentateur.rejoindreÉquipage(modèle.compteActif()) }

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_équipageTemporaire)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        présentateur.initisaliseurDesComptesTemporaires()
    }

    override fun gestionAfficherComptesÉquipageTemporaire(comptes: MutableList<Compte>?) {
        adaptateur = VueÉquipageTemporaireAdaptateur( comptes )
        recyclerView.adapter = adaptateur
    }

    override fun afficherTotalDoublons() {
        équipageTemporaire.setTotalDoublons()
        totalDoublonsTemporaire.text = équipageTemporaire.doublons.toString()
    }

    override fun afficherRang() {
        équipageTemporaire.setRang()
        numéroRangTemporaire.text = équipageTemporaire.rang.toString()
    }

    override fun naviguerVersDétailsCompteTemporaire() {
       navController.navigate(R.id.action_vueÉquipageTemporaire_to_vueCompteTemporaire)
    }

    override fun naviguerVersDétailsCompteActif() {
        navController.navigate(R.id.action_vueÉquipageTemporaire_to_vueCompteUtilisateur)
    }

}