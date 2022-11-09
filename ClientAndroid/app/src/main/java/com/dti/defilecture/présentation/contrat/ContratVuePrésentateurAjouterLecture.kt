package com.dti.defilecture.présentation.contrat

/**
 * Interface de contrats établissant les méthodes utiliser
 * dans un présentateur et sa vue correspondante.
 *
 */
interface ContratVuePrésentateurAjouterLecture {
    /**
     * Définit les méthodes à utiliser dans une vue AjouterLecture.
     */
    interface IVueAjouterLecture{
        fun afficherObligationDeLecture()
        /**
         * Ajoute un nombre de minutes au compteur de minutes total.
         */
        fun modifierMinutesAuCompteur(nombreDeMinutes: Int)

        /**
         * Réinitialise le compteur de minutes total à zéro.
         */
        fun réinitialiserMinutesAuCompteur()

        /**
         * Active le bouton de validation lorsque la lecture est valide.
         */
        fun activerBoutonLorsqueLectureValide()

        /**
         * Désactive le bouton de validation lorsque la lecture n'est pas valide.
         */
        fun désactiverBoutonLorsqueLectureInvalide()

        /**
         * Indique a l'utilisateur que des informations manque pour sa soumission.
         */
        fun afficherAvertissementInfosManquants(message: String)
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur AjouterLecture.
     */
    interface IPrésentateurAjouterLecture{
        fun traiterObligationDeLecture()
        /**
         * Ajoute des minutes lues au compteur dépendamment du bouton appuyé.
         */
        fun traiterAjouterMinutes(minuteAAjouter: Int, texteAuCompteur: String)

        /**
         * Ajoute une lecture a la liste de lecture fais par un étudiant.
         */
        fun traiterAjouterLecture(titre: String, minutes: Int, obligation: Boolean, lectureObligé: Boolean)

        /**
         * Reinitialise le compteur a 0.
         */
        fun traiterReinitialisationCompteur()

        /**
         * Valide si la lecture peut être ajouté dans la liste de lecture
         */
        fun traiterValiderLecture(titre: String, minutes: Int, obligation: Boolean)

        /**
         * Avertit l'utilisateur que des informations manque pour l'ajout de lecture.
         */
        fun avertirInfosManquant(titre: String, minutes: Int, obligation: Boolean)

    }
}