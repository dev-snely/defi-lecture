package com.dti.defilecture.présentation.ajouterlecture.obligation


import com.dti.defilecture.présentation.ajouterlecture.obligation.IContratVPAjouterLectureObligation.IPrésentateurAjouterLectureObligation
import com.dti.defilecture.présentation.ajouterlecture.obligation.IContratVPAjouterLectureObligation.IVueAjouterLectureObligation
import com.dti.defilecture.présentation.modèle


class PrésentateurAjouterLectureObligation(var vue: IVueAjouterLectureObligation): IPrésentateurAjouterLectureObligation {
    override fun naviguerVersMesLecture() {
        vue.naviguerVersMesLecture()
    }

    override fun traiterObligationDeLecture(
        btnSelectionné: Boolean,
        btnOuiSelectionné: Boolean,
        btnNonSelectionné: Boolean
    ) {
        if( btnSelectionné ){
            if ( btnOuiSelectionné ){
                modèle.ajouterObligationAUneLecture( true )
            }
            else if ( btnNonSelectionné ) {
                modèle.ajouterObligationAUneLecture( false )
            }
        }
    }

    override fun avertirInfoManquante(btnSelctionné: Boolean) {
        if ( !btnSelctionné ){
            vue.afficherAvertissementInfosManquants()
        }
    }

    override fun ajouterLectureDansLaSource() {
        modèle.ajouterLectureDansSourceDeDonnée()
        vue.avertirAjoutReussi()
    }
}
