package com.dti.defilecture.présentation.vue

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.dti.defilecture.R
import com.dti.defilecture.sourceDeDonnées.Remplir
import com.dti.defilecture.sourceDeDonnées.récupérerListeDeLecture

class VueMesLectures : Fragment() {


    lateinit var tvLecture: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_vue_mes_lectures, container, false)
        Remplir()
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvLecture = view.findViewById(R.id.txtBidon)

        var lectures = ""

        for(lecture in récupérerListeDeLecture()!!){
            lectures += lecture.titreLecture+" "+lecture.dateInscription+" "+lecture.obligatoire+"\n"+"\n"
        }

        tvLecture.text = lectures
    }

    private fun majLectures(){

    }


}