package com.dti.defilecture.présentation.ajouterlecture.obligation

/**
 * Interface de contrats établissant les méthodes utiliser
 * dans un présentateur et sa vue correspondante.
 *
 */
interface IContratVPAjouterLectureObligation {
    /**
     * Définit les méthodes à utiliser dans une vue AjouterLecture.
     */
    interface IVueAjouterLectureObligation{
        /**
         * Naviguer vers la liste de lecture de l'utilisateur
         */
        fun naviguerVersMesLecture()
        /**
         * Indique a l'utilisateur que des informations manque pour sa soumission.
         */
        fun afficherAvertissementInfosManquants()
        /**
         * Indique a l'utilisateur que l'ajout à réussi.
         */
        fun avertirAjoutReussi()
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur AjouterLecture.
     */
    interface IPrésentateurAjouterLectureObligation{
        fun avertirInfoManquante(btnSelectionné: Boolean)
        fun ajouterLectureDansLaSource()
        fun naviguerVersMesLecture()
        fun traiterObligationDeLecture(btnSelectionné: Boolean, btnNonSelectionné: Boolean, btnOuiSelectionné: Boolean)
    }
}