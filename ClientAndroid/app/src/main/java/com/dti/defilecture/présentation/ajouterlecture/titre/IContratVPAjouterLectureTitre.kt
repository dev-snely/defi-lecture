package com.dti.defilecture.présentation.ajouterlecture.titre

interface IContratVPAjouterLectureTitre {

    interface IVueAjouterLectureTitre{
        fun naviguerVersAjouterTempsLecture()
        fun afficherAvertissementInfosManquants()
    }
    interface IPrésentateurAjouterLectureTitre{
        fun traiterAjouterLectureTitre(titre: String)
        fun avertirInfosManquant( titre: String)
    }
}