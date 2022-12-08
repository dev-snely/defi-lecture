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
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.*


class VueÉquipage : Fragment(), IVueÉquipage  {
    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurÉquipage
    lateinit var adaptateur: VueÉquipageAdaptateur

    lateinit var nomÉquipage: TextView
    lateinit var numéroRang: TextView
    lateinit var totalDoublons: TextView

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

        nomÉquipage.text = équipage .nomÉquipage
        numéroRang.text = équipage .rang.toString()
        totalDoublons.text = équipage .doublonsÉquipage.toString()

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_équipage)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adaptateur = VueÉquipageAdaptateur( présentateur.initisaliseurDesComptes(nomÉquipage.text.toString()), présentateur)
        recyclerView.adapter = adaptateur

        //Différentes fonctions sur la vue.
        calculerTotalDoublons()
    }

    private fun calculerTotalDoublons() {
        totalDoublons.text = (0).toString() + " doublons"
    }

    override fun naviguerVersDétailsCompte() {
        navController.navigate(R.id.action_vueÉquipage_to_vueCompteTemporaire)
    }
}