package com.dti.defilecture.présentation.présentateur

import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.intéracteur.SourceDeLecture
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurAjouterLecture
import com.dti.defilecture.présentation.modèle.Modèle
import com.dti.defilecture.sourceDeDonnées.*

class PrésentateurAjouterLecture(var modèle : Modèle, var vue: ContratVuePrésentateurAjouterLecture.IVueAjouterLecture):
    ContratVuePrésentateurAjouterLecture.IPrésentateurAjouterLecture {

    init {
        Remplir()
    }

    override fun traiterObligationDeLecture() {
        vue.afficherObligationDeLecture()
    }

    override fun traiterAjouterMinutes(minuteAAjouter: Int, texteAuCompteur: String) {
        var texteAvecChiffreSeulement = texteAuCompteur.filter { it.isDigit() }
        var mins: Int = texteAvecChiffreSeulement.toInt()
        mins += minuteAAjouter
        vue.modifierMinutesAuCompteur(mins)
    }

    override fun traiterAjouterLecture(uneLecture: Lecture) {
        ajouterUneLecture(uneLecture)
    }

    override fun traiterReinitialisationCompteur() {
        vue.réinitialiserMinutesAuCompteur()
    }

    override fun traiterValiderLecture() {

    }


}