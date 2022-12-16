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
import com.dti.defilecture.présentation.compte.VueCompteUtilisateur
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.VueMesLecturesAdaptateur
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.*


class VueÉquipage : Fragment(), IVueÉquipage  {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurÉquipage
    lateinit var adaptateur: VueÉquipageAdaptateur

    lateinit var nomÉquipage: TextView
    lateinit var numéroRang: TextView
    lateinit var totalDoublons: TextView

    lateinit var comptes: MutableList<Compte>
    lateinit var recyclerView: RecyclerView

    val équipage = modèle.équipage()

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

        nomÉquipage = view.findViewById(R.id.tv_nomÉquipage)
        numéroRang = view.findViewById(R.id.tv_numéroRang)
        totalDoublons = view.findViewById(R.id.tv_totalDoublons)

        nomÉquipage.text = équipage.nomÉquipage
        afficherTotalDoublons()
        afficherRang()

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_équipage)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        présentateur.initisaliseurDesComptes(nomÉquipage.text.toString())
    }

    override fun gestionAfficherComptesÉquipage( comptes: MutableList<Compte>? ) {
        adaptateur = VueÉquipageAdaptateur(comptes)
        recyclerView.adapter = adaptateur
    }

    override fun afficherTotalDoublons() {
        équipage.setTotalDoublons()
        totalDoublons.text = équipage.doublons.toString()
    }

    override fun afficherRang() {
        équipage.setRang()
        numéroRang.text = équipage.rang.toString()
    }

    override fun naviguerVersDétailsCompteActif() {
        navController.navigate(R.id.action_vueÉquipage_to_vueCompteUtilisateur)
    }

    override fun naviguerVersDétailsCompteTemporaire() {
        navController.navigate(R.id.action_vueÉquipage_to_vueCompteTemporaire)
    }
}