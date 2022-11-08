package com.dti.defilecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.dti.defilecture.R
import com.dti.defilecture.présentation.vue.VueAjouterLecture
import com.dti.defilecture.présentation.vue.VueTrésorerie
import com.dti.defilecture.présentation.vue.VueÉquipage
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var barre_navigation: BottomNavigationView? = null
    var fragmentAjouterLecture : Fragment? = null

    var fragmentÉquipage : Fragment? = null

    var fragmentTrésorerie : Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentAjouterLecture = VueAjouterLecture()
        afficherFragmentCourant(fragmentAjouterLecture)

        fragmentÉquipage = VueÉquipage()
        afficherFragmentCourant(fragmentÉquipage)

        fragmentTrésorerie = VueTrésorerie()
        afficherFragmentCourant(fragmentTrésorerie)


        barre_navigation = findViewById(R.id.barre_navigation)
        barre_navigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_ajouter -> afficherFragmentCourant( fragmentAjouterLecture )
                R.id.ic_équipage -> afficherFragmentCourant( fragmentÉquipage )
                R.id.ic_trésorerie -> afficherFragmentCourant( fragmentTrésorerie )
                /*
                Pour afficher vos fragments avec la barre de navigation :
                ----------------------------------------------------------
                R.id.ic_equipage -> afficherFragmentCourant( fragmentEquipage )
                R.id.ic_compte -> afficherFragmentCourant( fragmentCompteUtilisateur )
                ----------------------------------------------------------
                 */
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