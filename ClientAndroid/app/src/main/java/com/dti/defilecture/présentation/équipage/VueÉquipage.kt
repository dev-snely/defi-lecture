package com.dti.defilecture.présentation.équipage

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
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.entité.Équipage
import com.dti.defilecture.présentation.compte.VueCompteUtilisateur
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.VueMesLecturesAdaptateur
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.*


class VueÉquipage : Fragment(), IVueÉquipage  {

    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurÉquipage
    lateinit var adaptateur: VueÉquipageAdaptateur
    lateinit var recyclerView: RecyclerView

    lateinit var nomÉquipage: TextView
    lateinit var numéroRang: TextView
    lateinit var totalDoublons: TextView

    var équipage: Équipage = modèle.initialiserÉquipage(modèle.compteActif().nomÉquipage)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_equipage, container, false)
        présentateur = PrésentateurÉquipage( this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_équipage)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        nomÉquipage = view.findViewById(R.id.tv_nomÉquipage)
        numéroRang = view.findViewById(R.id.tv_numéroRang)
        totalDoublons = view.findViewById(R.id.tv_totalDoublons)

        nomÉquipage.text = équipage.nomÉquipage
        afficherTotalDoublons()
        afficherRang()

        présentateur.initisaliseurDesComptes()
    }

    override fun gestionAfficherComptesÉquipage( comptes: MutableList<Compte>? ) {
        adaptateur = VueÉquipageAdaptateur(comptes)
        recyclerView.adapter = adaptateur
    }

    override fun afficherTotalDoublons() {
        équipage.setTotalDoublons()
        totalDoublons.text = équipage.doublons.toString() + " doublons"
    }

    override fun afficherRang() {
        équipage.setRang()
        numéroRang.text = "Rang# : " + équipage.rang.toString()
    }

    override fun naviguerVersDétailsCompteActif() {
        navController.navigate(R.id.action_vueÉquipage_to_vueCompteUtilisateur)
    }

    override fun naviguerVersDétailsCompteTemporaire() {
        navController.navigate(R.id.action_vueÉquipage_to_vueCompteTemporaire)
    }
}