package com.dti.defilecture.présentation.voirlectures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.IVueMesLectures
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.IPrésentateurMesLectures



class VueMesLectures : Fragment(), IVueMesLectures {

    lateinit var présentateur: IPrésentateurMesLectures
    lateinit var adaptateur: VueMesLecturesAdaptateur
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_vue_mes_lectures, container, false)
        présentateur = PrésentateurMesLectures( modèle, this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewLectures)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adaptateur = VueMesLecturesAdaptateur( présentateur.initisaliseurDeLectures() )
        recyclerView.adapter = adaptateur
    }
}