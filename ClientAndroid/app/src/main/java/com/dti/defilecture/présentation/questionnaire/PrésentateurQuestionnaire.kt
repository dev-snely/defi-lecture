package com.dti.defilecture.présentation.questionnaire

import com.dti.defilecture.présentation.Modèle
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.questionnaire.IContratVPQuestionnaire.IVueQuestionnaire
import com.dti.defilecture.présentation.questionnaire.IContratVPQuestionnaire.IPrésentateurQuestionnaire


class PrésentateurQuestionnaire( var vue: IVueQuestionnaire ): IPrésentateurQuestionnaire {
    var liste = modèle.obtenirListeQuestion()

    override fun getQuestion(): String {
        return liste[0].question
    }

    override fun getReponseA(): String {
        return liste[0].rep_A
    }

    override fun getReponseB(): String {
        return liste[0].rep_B
    }

    override fun getReponseC(): String {
        return liste[0].rep_C
    }

    override fun getReponseD(): String {
        return liste[0].rep_D
    }

    override fun bonneReponse(reponseChoisi: String) {
        if (liste[0].Bonne_reponse == reponseChoisi) {
            vue.afficherBonneReponse()
        }
        else{
            vue.afficherMauvaiseReponse()
        }
    }

}