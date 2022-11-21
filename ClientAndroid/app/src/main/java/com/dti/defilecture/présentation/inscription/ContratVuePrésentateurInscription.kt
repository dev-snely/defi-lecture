package com.dti.defilecture.présentation.inscription;

interface ContratVuePrésentateurInscription {
    /**
     * Définit les méthodes à utiliser dans une vue Inscription.
     */
    interface IVueInscription{
        /**
         * Indique a l'utilisateur que des informations manque pour son inscription.
         */
        fun afficherAvertissementInfosManquants(message: String)


    }
    /**
     * Définit les méthodes à utiliser dans un présentateur Inscription.
     */
    interface IPrésentateurInscription{
        /**
         * Création d'un compte.
         */
        fun traiterInscription(prenomCompte: String, nomCompte: String, courrielCompte: String,
                               pseudonymeCompte: String, programmeCompte: String, motDePasseCompte: String)
        /**
         * Avertit l'utilisateur que des informations manque pour l'inscription.
         */
        fun verifierInfosManquant(prenomCompte: String, nomCompte: String, courrielCompte: String,
                                 pseudonymeCompte: String, programmeCompte: String,
                                 motDePasseCompte: String, motDePasseCompteValidation: String)

    }
}
