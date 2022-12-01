package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accèsAuxDonnées.question.SourceDeQuestions
import com.dti.defilecture.domaine.entité.Questionnaire

/**
 * Classe d'intéraction permettant la manipulation d'objets Questionnaire avec sa source de données respective.
 */
class InteractionSourceDeQuestions {
    var sourceDeQuestion : SourceDeQuestions = SourceDeQuestions()

    /**
     * Méthode qui obtient des questions depuis la source de données.
     *
     * @returns Un tableau d'objets Questionnaire.
     */
    fun obtenirQuestionInteracteur():Array<Questionnaire>{
       return sourceDeQuestion.obtenirQuestions()
    }
}