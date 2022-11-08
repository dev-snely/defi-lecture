package com.dti.defilecture.ui

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Personne
import com.dti.defilecture.présentation.modèle.MyAdapter
import com.dti.defilecture.présentation.vue.VueAjouterLecture
import com.dti.defilecture.présentation.vue.VueÉquipage
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var barre_navigation: BottomNavigationView? = null
    var fragmentAjouterLecture : Fragment? = null

    var fragmentÉquipage : Fragment? = null
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var listeÉquipage : ArrayList<Personne>
    lateinit var nomPersonnes : Array<String>
    lateinit var doublonsPersonnes : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentAjouterLecture = VueAjouterLecture()
        afficherFragmentCourant(fragmentAjouterLecture)

        barre_navigation = findViewById(R.id.barre_navigation)
        barre_navigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_ajouter -> afficherFragmentCourant( fragmentAjouterLecture )
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

        fragmentÉquipage = VueÉquipage()
        afficherFragmentCourant(fragmentÉquipage)

        nomPersonnes = arrayOf("Gerard", "Snely", "Vu Minh", "Ovidiu", "Jonathan")
        doublonsPersonnes = arrayOf(10, 20, 30, 40 , 50)
        newRecyclerView = findViewById(R.id.listePersonnesÉquipage)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        listeÉquipage = arrayListOf<Personne>()
        getUserData()

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

    private fun getUserData() {
        for (i in 0 until nomPersonnes.size){
            val personneÉquipage = Personne(nomPersonnes[i],doublonsPersonnes[i])
            listeÉquipage.add(personneÉquipage)
        }

        newRecyclerView.adapter = MyAdapter(listeÉquipage)

    }
}