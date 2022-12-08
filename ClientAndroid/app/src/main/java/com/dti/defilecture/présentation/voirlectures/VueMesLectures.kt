package com.dti.defilecture.présentation.voirlectures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.*

class VueMesLectures : Fragment(), IVueMesLectures {
    lateinit var navController : NavController
    lateinit var btnAjouter: Button
    lateinit var présentateur: IPrésentateurMesLectures
    lateinit var adaptateur: VueMesLecturesAdaptateur
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_vue_mes_lectures, container, false)
        présentateur = PrésentateurMesLectures( this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btnAjouter = view.findViewById(R.id.ajouterUneLecture)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewLectures)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adaptateur = VueMesLecturesAdaptateur( présentateur.initisaliseurDeLectures() )
        recyclerView.adapter = adaptateur

        gestionAjoutDeLecture()
    }

    private fun gestionAjoutDeLecture(){
        btnAjouter.setOnClickListener {
            naviguerVersAjoutTitreLecture()
        }
    }

    override fun naviguerVersAjoutTitreLecture() {
        navController.navigate(R.id.action_vueMesLectures_to_vueAjouterLectureTitre)
    }
}