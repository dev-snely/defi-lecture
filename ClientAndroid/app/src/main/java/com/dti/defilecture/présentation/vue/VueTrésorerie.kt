package com.dti.defilecture.présentation.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurTrésorerie
import com.dti.defilecture.présentation.modèle.Modèle
import com.dti.defilecture.présentation.présentateur.PrésentateurTrésorerie


class VueTrésorerie : Fragment(), ContratVuePrésentateurTrésorerie.IVueTrésorerie  {

    lateinit var présentateur : ContratVuePrésentateurTrésorerie.IPrésentateurTrésorerie
    lateinit var équipageRecherche: EditText
    lateinit var listeÉquipages: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_tresorerie, container, false)
        présentateur = PrésentateurTrésorerie( Modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialisations
        équipageRecherche = view.findViewById(R.id.et_searchÉquipage)
        listeÉquipages = view.findViewById(R.id.lv_listeÉquipages)

        //Différente fonctions sur la vue.
        rechercherUneÉquipe()
        afficherUneÉquipe()
    }

    private fun afficherUneÉquipe() {
        TODO("Not yet implemented")
    }

    private fun rechercherUneÉquipe() {
        TODO("Not yet implemented")
    }
}