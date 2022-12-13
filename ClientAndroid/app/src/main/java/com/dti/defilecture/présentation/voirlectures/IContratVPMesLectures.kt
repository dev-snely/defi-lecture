package com.dti.defilecture.présentation.voirlectures

import com.dti.defilecture.domaine.entité.Lecture

interface IContratVPMesLectures {

    interface IVueMesLectures{
        /**
         * Méthode qui permet d'avancer vers l'ajout d'une lecture.
         */
        fun naviguerVersAjoutTitreLecture()

        /**
         * Méthode qui permet d'afficher un message d'erreur dans le cas d'une requête échouéec.
         */
        fun afficherMessageErreurInternet()

        fun gestionAfficherLecture( lectures: MutableList<Lecture>? )
    }

    interface IPrésentateurMesLectures{
        /**
         * Méthode qui récupère les données de l'utilisateur connecté
         */
        fun requêteRécupérationLecturesUtilisateurConnecté()

        /**
         * Permet de naviguer vers l'ajout de lecture,
         */
        fun requêteNaviguerVersAjoutTitreLecture()
    }
}