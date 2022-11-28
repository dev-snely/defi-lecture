package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Compte

class SourceDeComptesBidons : ISourcesDeDonnéesÉquipage{

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
            Compte("Prenom","Nom",10,"admin@crosemont.qc.ca", "Admin", "idk", "mdp"),
            Compte("Prenom","Nom",100,"admin@crosemont.qc.ca", "Joueur1", "idk", "mdp"),
            Compte("Prenom","Nom",1000,"admin@crosemont.qc.ca", "Joueur2", "idk", "mdp")
        )
    }
}