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
        fun naviguerVersAjouterLectureObligation()
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur AjouterLecture.
     */
    interface IPrésentateurAjouterLectureTemps{
        /**
         * Ajoute des minutes lues au compteur dépendamment du bouton appuyé.
         */
        fun traiterAjouterMinutes(minuteAAjouter: Int, texteAuCompteur: String)
        /**
         * Reinitialise le compteur a 0.
         */
        fun traiterReinitialisationCompteur()
    }
}