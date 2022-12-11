package com.dti.defilecture.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dti.defilecture.R
import com.dti.defilecture.accèsAuxDonnées.SourceDeDonnéesHTTP
import com.dti.defilecture.présentation.LocaleHelper
import com.dti.defilecture.présentation.modèle
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.net.URL


class MainActivity : AppCompatActivity() {

    lateinit var barre_navigation: BottomNavigationView
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)
        modèle.localHelper=LocaleHelper(this)
        modèle.sourceDeDonnées = SourceDeDonnéesHTTP( this, URL("http://10.0.2.2:51723") )
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_1) as NavHostFragment
        navController = navHostFragment.navController
        barre_navigation = findViewById(R.id.barre_navigation)
        modePleinEcran()
        barre_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_ajouter -> navController.navigate( R.id.action_global_vueMesLectures )
                R.id.ic_équipage ->navController.navigate( R.id.action_global_vueÉquipage)
                R.id.ic_trésorerie -> navController.navigate( R.id.action_global_vueTrésorerie)
                R.id.ic_epreuve -> navController.navigate( R.id.action_global_vueQuestionnaire )
                R.id.ic_compte -> navController.navigate( R.id.action_global_vueCompteUtilisateur )
            }
            true
        }
    }

    fun modePleinEcran() {
        val decorView: View = window.decorView
        val uiOptions: Int =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.setSystemUiVisibility(uiOptions)
    }

}