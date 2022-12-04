package com.dti.defilecture.accèsAuxDonnées

import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.entité.Questionnaire
import com.dti.defilecture.domaine.entité.Équipage

class SourceDeDonnéesHTTP : ISourceDeDonnées {
    override fun validerComptePourLaConnexion(pseudo: String, mdp: String): Compte? {
        TODO("Not yet implemented")
    }

    override fun obtenirListeDesComptesÉquipage(): MutableList<Compte> {
        TODO("Not yet implemented")
    }

    override fun obtenirListeDeLecturesBidon(): MutableList<Lecture>? {
        TODO("Not yet implemented")
    }

    override fun ajouterUneLectureALaListe(lecture: Lecture) {
        TODO("Not yet implemented")
    }

    override fun obtenirQuestions(): Array<Questionnaire> {
        TODO("Not yet implemented")
    }

    override fun obtenirListeDesÉquipages(): MutableList<Équipage>? {
        TODO("Not yet implemented")
    }
}