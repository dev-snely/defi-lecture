package com.dti.defilecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.compte.VueCompteUtilisateur
import com.dti.defilecture.présentation.trésorerie.VueTrésorerie
import com.dti.defilecture.présentation.voirlectures.VueMesLectures
import com.dti.defilecture.présentation.épreuve.VueÉpreuve
import com.dti.defilecture.présentation.équipage.VueÉquipage
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.fragment.NavHostFragment
import com.dti.defilecture.présentation.ajouterlecture.VueAjouterLecture

class MainActivity : AppCompatActivity() {
    lateinit var barre_navigation: BottomNavigationView
    lateinit var fragmentMesLectures: Fragment
    lateinit var fragmentCompteUtilisateur: Fragment
    lateinit var fragmentÉquipage : Fragment
    lateinit var fragmentTrésorerie : Fragment
    lateinit var fragmentÉpreuve : Fragment
    lateinit var fragmentAjout : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)

        fragmentMesLectures = VueMesLectures()
        fragmentÉquipage = VueÉquipage()
        fragmentTrésorerie = VueTrésorerie()
        fragmentÉpreuve = VueÉpreuve()
        fragmentCompteUtilisateur = VueCompteUtilisateur()
        fragmentAjout = VueAjouterLecture()

        barre_navigation = findViewById(R.id.barre_navigation)

        afficherFragmentCourant( fragmentMesLectures )
        gestionBarreNacigation()
    }

    /** Fonction qui affiche un fragment selon l'icone cliqué dans la barre de navigation.
     *
    */
    private fun gestionBarreNacigation() {
        barre_navigation.setOnItemSelectedListener {
            when(it.itemId){
                //R.id.ic_ajouter -> afficherFragmentCourant( fragmentAjout )
                R.id.ic_ajouter -> afficherFragmentCourant( fragmentMesLectures )
                R.id.ic_équipage -> afficherFragmentCourant( fragmentÉquipage )
                R.id.ic_trésorerie -> afficherFragmentCourant( fragmentTrésorerie )
                R.id.ic_epreuve -> afficherFragmentCourant(fragmentÉpreuve)
                R.id.ic_compte -> afficherFragmentCourant(fragmentCompteUtilisateur)
            }
            true
        }
    }

    /** Fonction qui affiche le fragment spécifié comme paramètre de la fonction.
     *
     * @param fragment Le fragment que l'on veut afficher.
     */
    private fun afficherFragmentCourant(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            addToBackStack(null)
            commit()
        }
    }
}