package com.dti.defilecture.présentation.ajouterlecture.titre

import com.dti.defilecture.présentation.ajouterlecture.titre.IContratVPAjouterLectureTitre.IPrésentateurAjouterLectureTitre
import com.dti.defilecture.présentation.ajouterlecture.titre.IContratVPAjouterLectureTitre.IVueAjouterLectureTitre
import com.dti.defilecture.présentation.modèle

class PrésentateurAjouterLectureTitre(var vue: IVueAjouterLectureTitre ) : IPrésentateurAjouterLectureTitre {
    override fun traiterAjouterLectureTitre(titre: String) {
        modèle.initialiserLecture()
        if( titre.isNotEmpty() ) {
            modèle.ajouterTitreAUneLecture( titre )
            if( !modèle.verifierLectureTitreManquant() ){
                vue.naviguerVersAjouterTempsLecture()
            }
        }
    }

    override fun avertirInfosManquant(titre: String) {
        if( titre.isEmpty() ){
            vue.afficherAvertissementInfosManquants()
        }
    }
}