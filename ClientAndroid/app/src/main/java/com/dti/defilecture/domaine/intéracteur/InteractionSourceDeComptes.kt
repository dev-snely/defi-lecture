package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accèsAuxDonnées.compte.ISourceDeComptes
import com.dti.defilecture.domaine.entité.Compte

/**
 * Classe d'intéraction permettant la manipulation d'objets comptes avec sa source de données.
 */
class InteractionSourceDeComptes(var sourceDeDonnées: ISourceDeComptes) {

    /**
     * Méthode qui permet de récupérer un Compte, puis d'initialiser la session
     * d'utilisation de l'utilisateur avec le compte récupéré.
     */
    fun récupérerComptePourConnexion( pseudo: String, mdp: String ): Compte?{
        return sourceDeDonnées.validerComptePourLaConnexion(pseudo,mdp)
    }
}
