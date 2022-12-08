package com.dti.defilecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.LocaleHelper
import com.dti.defilecture.présentation.modèle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var barre_navigation: BottomNavigationView
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)
        modèle.localHelper=LocaleHelper(this)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_1) as NavHostFragment
        navController = navHostFragment.navController
        barre_navigation = findViewById(R.id.barre_navigation)

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
}