package com.dti.defilecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dti.defilecture.R

import com.dti.defilecture.présentation.vue.*

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var barre_navigation: BottomNavigationView? = null

    var fragmentAjouterLecture: Fragment? = null
    var fragmentMesLectures: Fragment? = null
    var fragmentEquipage: Fragment? = null
    var fragmentTresorerie: Fragment? = null
    var fragmentEpreuve: Fragment? = null
    var fragmentCompteUtilisateur: Fragment? = null
    var fragmentInscription : Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.fragment_inscription)

/*

        //Page AjouterLecture
        fragmentAjouterLecture = VueAjouterLecture()
        fragmentInscription = VueInscription()
        afficherFragmentCourant(fragmentAjouterLecture)

        //Page MesLectures
        fragmentMesLectures = VueMesLectures()

        //Page Equipage
        fragmentEquipage = VueEquipage()

        //Page Tresorerie
        fragmentTresorerie = VueTresorerie()

        //Page Epreuve
        fragmentEpreuve = VueEpreuve()

        //Page CompteUtilisateur
        fragmentCompteUtilisateur = VueCompteUtilisateur()



        barre_navigation = findViewById(R.id.barre_navigation)
        barre_navigation?.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.ic_ajouter -> afficherFragmentCourant(fragmentAjouterLecture)
                /*
               Pour afficher vos fragments avec la barre de navigation :
               ----------------------------------------------------------
               ----------------------------------------------------------
                */
                R.id.ic_equipage -> afficherFragmentCourant(fragmentEquipage)
                R.id.ic_tresorerie -> afficherFragmentCourant(fragmentTresorerie)
                R.id.ic_epreuve -> afficherFragmentCourant(fragmentEpreuve)
                R.id.ic_compte -> afficherFragmentCourant(fragmentMesLectures)
                /*
                Le fragment MesLectures d\utilise ce bouton en attendant le sprint 3
                R.id.ic_compte -> afficherFragmentCourant( fragmentCompteUtilisateur )
                * */
            }
            true
        }


    }
    /** Fonction qui affiche le fragment spécifié comme paramètre de la fonction.
     *
     * @param fragment Le fragment que l'on veut afficher.
     */
    private fun afficherFragmentCourant(fragment: Fragment?) {
        supportFragmentManager.beginTransaction().apply {
            if (fragment != null) {
                replace(R.id.fl_wrapper, fragment)
            }
            addToBackStack(null)
            commit()
        }*/
    }
}