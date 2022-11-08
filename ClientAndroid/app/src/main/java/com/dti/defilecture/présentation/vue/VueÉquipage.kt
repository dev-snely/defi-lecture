package com.dti.defilecture.présentation.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurÉquipage
import com.dti.defilecture.présentation.modèle.Modèle
import com.dti.defilecture.présentation.présentateur.PrésentateurÉquipage


class VueÉquipage : Fragment(), ContratVuePrésentateurÉquipage.IVueÉquipage  {
    lateinit var présentateur : ContratVuePrésentateurÉquipage.IPrésentateurÉquipage
    lateinit var nomÉquipage: TextView
    lateinit var numéroRang: TextView
    lateinit var totalDoublons: TextView
    lateinit var listePersonnesÉquipage: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_equipage, container, false)
        présentateur = PrésentateurÉquipage( Modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialisations
        nomÉquipage = view.findViewById(R.id.tv_nomÉquipage)
        numéroRang = view.findViewById(R.id.tv_numéroRang)
        totalDoublons = view.findViewById(R.id.tv_totalDoublons)
        listePersonnesÉquipage = view.findViewById(R.id.lv_listePersonnesÉquipage)

        //Différentes fonctions sur la vue.
        calculerTotalDoublons()
    }

    private fun calculerTotalDoublons() {
        totalDoublons.text = (0).toString()
    }
}