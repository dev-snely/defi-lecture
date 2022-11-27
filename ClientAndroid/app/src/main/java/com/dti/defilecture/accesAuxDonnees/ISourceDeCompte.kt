package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Compte

interface ISourceDeCompte {
    /**
     * Méthode qui permet de valider si un compte existe pour se connecter.
     *
     * @param pseudo pseudonyme
     * @param mdp mot de passe
     */
    fun validerComptePourLaConnexion( pseudo : String, mdp : String ): Compte?

}