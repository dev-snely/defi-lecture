package com.dti.defilecture.présentation.contrat;

interface ContratVuePrésentateurInscription {
    /**
     * Définit les méthodes à utiliser dans une vue Inscription.
     */
    interface IVueInscription{
        /**
         * Active le bouton de validation lorsque l'inscription est valide.
         */
        fun activerBoutonInscriptionLorsqueLectureValide()

        /**
         * Désactive le bouton de validation lorsque les données ne sont pas valide.
         */
        fun désactiverBoutonInscriptionLorsqueLectureInvalide()
        /**
         * Indique a l'utilisateur que des informations manque pour sa soumission.
         */
        fun afficherAvertissementInfosManquants(message: String)

    }
    /**
     * Définit les méthodes à utiliser dans un présentateur Inscription.
     */
    interface IPrésentateurInscription{
        /**
         * Ajoute une lecture a la liste de lecture fais par un étudiant.
         */
        fun traiterInscription(prenomCompte: String, nomCompte: String, courrielCompte: String,
                               pseudonymeCompte: String, programmeCompte: String, motDePasseCompte: String)
        /**
         * Avertit l'utilisateur que des informations manque pour l'inscription.
         */
        fun avertirInfosManquant(prenomCompte: String, nomCompte: String, courrielCompte: String,
                                 pseudonymeCompte: String, programmeCompte: String,
                                 motDePasseCompte: String, motDePasseCompteValidation: String)

    }
}
