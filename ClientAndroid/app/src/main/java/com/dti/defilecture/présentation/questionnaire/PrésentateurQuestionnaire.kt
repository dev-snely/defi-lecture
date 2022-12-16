package com.dti.defilecture.présentation.questionnaire

import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.questionnaire.IContratVPQuestionnaire.IVueQuestionnaire
import com.dti.defilecture.présentation.questionnaire.IContratVPQuestionnaire.IPrésentateurQuestionnaire


class PrésentateurQuestionnaire( var vue: IVueQuestionnaire ): IPrésentateurQuestionnaire {
    var question = modèle.obtenirQuestionModèle()

    override fun getQuestion(): String {
        return question.question
    }

    override fun getReponseA(): String {
        return question.rep_A
    }

    override fun getReponseB(): String {
        return question.rep_B
    }

    override fun getReponseC(): String {
        return question.rep_C
    }

    override fun getReponseD(): String {
        return question.rep_D
    }

    override fun bonneReponse(reponseChoisi: String) {
        if (modèle.obtenirBonneReponseModèle(question) == reponseChoisi) {
            vue.afficherBonneReponse()
        }
        else{
            vue.afficherMauvaiseReponse()
        }
    }

}