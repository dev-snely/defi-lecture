package com.dti.defilecture.présentation.contrat

import com.dti.defilecture.domaine.entité.Lecture

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
         * Afficher si le livre était obligatoire on non.
         */
        fun afficherObligationDeLecture()
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
        fun traiterAjouterLecture(uneLecture: Lecture)

        /**
         * Reinitialise le compteur a 0.
         */
        fun traiterReinitialisationCompteur()

        /**
         * Valide si la lecture peut être ajouté dans la liste de lecture
         */
        fun traiterValiderLecture()
    }
}