package com.dti.defilecture.présentation.équipage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.modèle


class VueÉquipage : Fragment(), ContratVuePrésentateurÉquipage.IVueÉquipage  {
    lateinit var présentateur : ContratVuePrésentateurÉquipage.IPrésentateurÉquipage
    lateinit var nomÉquipage: TextView
    lateinit var numéroRang: TextView
    lateinit var totalDoublons: TextView
    lateinit var listePersonnesÉquipage: ListView
    lateinit var adapter : ArrayAdapter<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_equipage, container, false)
        présentateur = PrésentateurÉquipage( modèle, this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialisations
        nomÉquipage = view.findViewById(R.id.tv_nomÉquipage)
        numéroRang = view.findViewById(R.id.tv_numéroRang)
        totalDoublons = view.findViewById(R.id.tv_totalDoublons)
        listePersonnesÉquipage = view.findViewById(R.id.lv_listePersonnesÉquipage)

        adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.liste_personnes))
        listePersonnesÉquipage.adapter = adapter
        listePersonnesÉquipage.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(context, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }

        //Différentes fonctions sur la vue.
        calculerTotalDoublons()
    }

    private fun calculerTotalDoublons() {
        totalDoublons.text = (0).toString() + " doublons"
    }
}