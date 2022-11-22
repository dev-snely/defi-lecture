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
        fun naviguerVersMesLecture()
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur AjouterLecture.
     */
    interface IPrésentateurAjouterLectureObligation{
        fun naviguerVersMesLecture()
        fun traiterObligationDeLecture()
        /**
         * Ajoute une lecture a la liste de lecture fais par un étudiant.
         */
        fun traiterAjouterLecture(titre: String, minutes: Int, obligation: Boolean, lectureObligé: Boolean)
    }
}