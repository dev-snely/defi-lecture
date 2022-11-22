package com.dti.defilecture.présentation.ajouterlecture.temps


import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IVueAjouterLectureTemps
import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IPrésentateurAjouterLectureTemps
import com.dti.defilecture.présentation.modèle


class PrésentateurAjouterLectureTemps(var vue: IVueAjouterLectureTemps): IPrésentateurAjouterLectureTemps {

    override fun traiterAjouterMinutes(minuteAAjouter: Int, texteAuCompteur: String) {
        var minutesAuCompteur = texteAuCompteur.filter { it.isDigit() }.toInt()

        minutesAuCompteur += minuteAAjouter

        vue.modifierMinutesAuCompteur(minutesAuCompteur)
    }

    override fun traiterReinitialisationCompteur() {
        vue.réinitialiserMinutesAuCompteur()
    }

    override fun naviguerVersAjouterLectureObligation() {
        vue.naviguerVersAjouterLectureObligation()
    }

    override fun avertirInfosManquant(minutes: Int) {
        if( modèle.verifierLectureDureeManquante()  ){
            vue.afficherAvertissementInfosManquants("Vous n'avez entré aucune minute.")
        }
    }

}