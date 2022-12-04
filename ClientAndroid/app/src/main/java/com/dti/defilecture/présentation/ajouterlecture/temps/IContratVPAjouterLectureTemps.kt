package com.dti.defilecture.présentation.ajouterlecture.temps

/**
 * Interface de contrats établissant les méthodes utiliser
 * dans un présentateur et sa vue correspondante.
 *
 */
interface IContratVPAjouterLectureTemps {
    /**
     * Définit les méthodes à utiliser dans une vue AjouterLecture.
     */
    interface IVueAjouterLectureTemps{
        /**
         * Naviguer vers la prochaine page, Ajout d'obligation.
         */
        fun naviguerVersAjouterLectureObligation()

        /**
         * Modifie les minutes présente sur le compteur avec les minutes en paramètre.
         *
         * @param nombreDeMinutes Nombre de minutes à placer.
         */
        fun modifierMinutesAuCompteur(nombreDeMinutes: Int)

        /**
         * Reinitialise le compteur a 0 minute.
         */
        fun réinitialiserMinutesAuCompteur()

        /**
         * Affiche un avertissement d'informations manquantes.
         */
        fun afficherAvertissementInfosManquants()
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur AjouterLecture.
     */
    interface IPrésentateurAjouterLectureTemps{
        /**
         * Ajoute des minutes lues au compteur dépendamment du bouton appuyé.
         *
         * @param minuteAAjouter Minute a ajouter au compteur.
         * @param texteAuCompteur Minute actuel au compteur.
         */
        fun traiterAjouterMinutes(minuteAAjouter: Int, texteAuCompteur: String)

        /**
         * Reinitialise le compteur a 0.
         */
        fun traiterReinitialisationCompteur()

        /**
         * Naviguer vers la page d'obligation
         *
         * @param texteAuCompteur Les minutes au compteur.
         */
        fun naviguerVersAjouterLectureObligation( texteAuCompteur: String )

        fun avertirInfosManquant(texteAuCompteur : String)

    }
}