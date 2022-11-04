package com.dti.defilecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.vue.FragmentAjouterLecture
import com.dti.defilecture.présentation.vue.FragmentEquipage
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var barre_navigation: BottomNavigationView? = null
    var fragmentAjouterLecture : Fragment? = null
    var fragmentEquipage : Fragment? = null
    var fragmentTresorie : Fragment? = null
    var fragmentEpreuve : Fragment? = null
    var fragmentCompteUtilisateur : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentAjouterLecture = FragmentAjouterLecture()
        afficherFragmentCourant(fragmentAjouterLecture)

        fragmentEquipage = FragmentEquipage()
        afficherFragmentCourant(fragmentEquipage)


        barre_navigation = findViewById(R.id.barre_navigation)
        barre_navigation?.setOnItemSelectedListener {
            when(it.itemId){
                /*
               Pour afficher vos fragments avec la barre de navigation :
               ----------------------------------------------------------
               R.id.ic_tresorie -> afficherFragmentCourant( fragmentTresorie )
               R.id.ic_epreuve -> afficherFragmentCourant ( fragmentEpreuve )
               R.id.ic_compte -> afficherFragmentCourant( fragmentCompteUtilisateur )
               ----------------------------------------------------------
                */
                R.id.ic_ajouter -> afficherFragmentCourant( fragmentAjouterLecture )
                R.id.ic_equipage -> afficherFragmentCourant( fragmentEquipage )
            }
            true
        }
    }

    /** Fonction qui affiche le fragment spécifié comme paramètre de la fonction.
     *
     * @param fragment Le fragment que l'on veut afficher.
     */
    private fun afficherFragmentCourant(fragment: Fragment?){
        supportFragmentManager.beginTransaction().apply {
            if (fragment != null) {
                replace(R.id.fl_wrapper, fragment)
            }
            addToBackStack(null)
            commit()
        }
    }
}