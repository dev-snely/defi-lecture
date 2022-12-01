package com.dti.defilecture.accèsAuxDonnées.compte

import com.dti.defilecture.domaine.entité.Compte

/**
 * Interface qui définit ce qu'une source de compte possède comme méthodes.
 */
interface ISourceDeComptes {
    /**
     * Méthode qui permet de valider si un compte existe pour s'identifier, puis s'y connecter.
     *
     * @param pseudo pseudonyme de l'utilisateur.
     * @param mdp mot de passe de l'utilisateur.
     */
    fun validerComptePourLaConnexion( pseudo : String, mdp : String ): Compte?

}