package com.dti.defilecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.compte.VueCompteUtilisateur
import com.dti.defilecture.présentation.trésorerie.VueTrésorerie
import com.dti.defilecture.présentation.voirlectures.VueMesLectures
import com.dti.defilecture.présentation.épreuve.VueÉpreuve
import com.dti.defilecture.présentation.équipage.VueÉquipage
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.fragment.NavHostFragment
import com.dti.defilecture.présentation.ajouterlecture.VueAjouterLecture
import com.dti.defilecture.présentation.ajouterlecture.titre.VueAjouterLectureTitre

class MainActivity : AppCompatActivity() {
    lateinit var barre_navigation: BottomNavigationView
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_1) as NavHostFragment
        navController = navHostFragment.navController
        barre_navigation = findViewById(R.id.barre_navigation)

        barre_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_ajouter -> navController.navigate( R.id.action_global_vueMesLectures )
                R.id.ic_équipage ->navController.navigate( R.id.action_global_vueÉquipage)
                R.id.ic_trésorerie -> navController.navigate( R.id.action_global_vueTrésorerie)
                R.id.ic_epreuve -> navController.navigate( R.id.action_global_vueÉpreuve )
                R.id.ic_compte -> navController.navigate( R.id.action_global_vueCompteUtilisateur )
            }
            true
        }
    }
}