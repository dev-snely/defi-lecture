package com.dti.defilecture.domaine.intéracteur;

import com.dti.defilecture.accesAuxDonnees.SourceDeCompteBidons
import com.dti.defilecture.domaine.entité.Compte

class InteractionSourceDeCompte {

    var sourceDeDonnées: SourceDeCompteBidons = SourceDeCompteBidons()

    fun récupérerComptePourConnexion( pseudo: String, mdp: String ): Compte?{
        return sourceDeDonnées.validerComptePourLaConnexion(pseudo,mdp)
    }
}
