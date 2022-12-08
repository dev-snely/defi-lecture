package com.dti.defilecture.présentation.langage

import android.graphics.Color
import android.widget.Button
import com.dti.defilecture.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.dti.defilecture.présentation.LocaleHelper
import com.dti.defilecture.présentation.langage.IContratVPLangage.IPrésentateurLangage
import com.dti.defilecture.présentation.langage.IContratVPLangage.IVueLangage
import com.dti.defilecture.présentation.modèle

class VueLangage: Fragment(), IVueLangage {

    lateinit var navController : NavController
    lateinit var présentateur: IPrésentateurLangage
    lateinit var btnFrançais: Button
    lateinit var btnEnglish: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_langage, container, false)
        présentateur = PrésentateurLangage( this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnFrançais = view.findViewById(R.id.btnFrançais)
        btnEnglish = view.findViewById(R.id.btnEnglish)

        btnFrançais.setOnClickListener {
            présentateur.changerLangueFrançais()
        }
        btnEnglish.setOnClickListener {
            présentateur.changerLangueEnglish()
        }
        if(modèle.localHelper?.getLanguage()=="en-rCA"){
            btnEnglish.setBackgroundColor(Color.parseColor("#FF4CAF50"))
        }else{
            btnFrançais.setBackgroundColor(Color.parseColor("#FF4CAF50"))
        }
    }
    override fun boutonActifFrançais(){
        btnFrançais.setBackgroundColor(Color.parseColor("#FF4CAF50"))
        btnEnglish.setBackgroundColor(Color.BLACK)
    }
    override fun boutonActifEnglish(){
        btnEnglish.setBackgroundColor(Color.parseColor("#FF4CAF50"))
        btnFrançais.setBackgroundColor(Color.BLACK)
    }

}