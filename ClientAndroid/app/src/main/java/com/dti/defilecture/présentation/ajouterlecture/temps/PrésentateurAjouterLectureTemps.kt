package com.dti.defilecture.présentation.ajouterlecture.temps


import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IVueAjouterLectureTemps
import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IPrésentateurAjouterLectureTemps
import com.dti.defilecture.présentation.modèle


class PrésentateurAjouterLectureTemps(var vue: IVueAjouterLectureTemps): IPrésentateurAjouterLectureTemps {

    override fun traiterAjouterMinutes(minuteAAjouter: Int, texteAuCompteur: String) {
        var minutesAuCompteur = texteAuCompteur.filter { it.isDigit() }

        if ( minutesAuCompteur.isNotEmpty() ) {
            var minutesEntières = minutesAuCompteur.toInt()
            minutesEntières += minuteAAjouter
            vue.modifierMinutesAuCompteur(minutesEntières)
        } else {
            vue.modifierMinutesAuCompteur(minuteAAjouter)
        }
    }

    override fun traiterReinitialisationCompteur() {
        vue.réinitialiserMinutesAuCompteur()
    }

    override fun naviguerVersAjouterLectureObligation(texteAuCompteur: String) {
        var minutesAuCompteur = texteAuCompteur.filter { it.isDigit() }

        if ( minutesAuCompteur.isNotEmpty() ){
            var minutesEntières = minutesAuCompteur.toInt()
            modèle.ajouterTempsAUneLecture( minutesEntières )
            if ( !modèle.verifierLectureDureeManquante() ){
                vue.naviguerVersAjouterLectureObligation()
            }
        }
    }

    override fun avertirInfosManquant(texteAuCompteur: String) {
        var minutesAuCompteur = texteAuCompteur.filter { it.isDigit() }
        if( minutesAuCompteur.isEmpty() ){
            vue.afficherAvertissementInfosManquants()
        }
    }

}