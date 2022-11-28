package com.dti.defilecture.accesAuxDonnees

import android.util.Log
import com.dti.defilecture.domaine.entité.Compte
import java.util.*


class SourceDeComptesBidons : ISourcesDesComptesÉquipage{

    init {
        RemplirComptes()
    }

    override fun obtenirListeDesComptesÉquipage(): MutableList<Compte>? {
        return comptes
    }
}

var comptes: MutableList<Compte>? = null

fun RemplirComptes() {
    if (comptes.isNullOrEmpty()) {
        comptes = mutableListOf(
            Compte( "Prenom","Nom",0,"admin@crosemont.qc.ca", "Admin", "idk", "mdp")
        )
    }
}

