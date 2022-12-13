package com.dti.defilecture.présentation.voirlectures

import com.dti.defilecture.domaine.entité.Lecture

interface IContratVPMesLectures {

    interface IVueMesLectures{
        /**
         * Méthode qui permet
         */
        fun naviguerVersAjoutTitreLecture()
    }

    interface IPrésentateurMesLectures{
        /**
         * Méthode qui récupère les données de l'utilisateur connecté
         */
        fun requêteRécupérationLecturesUtilisateurConnecté()
    }
}