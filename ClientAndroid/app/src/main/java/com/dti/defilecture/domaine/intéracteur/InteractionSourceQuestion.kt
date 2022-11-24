package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accesAuxDonnees.SourceQuestion
import com.dti.defilecture.domaine.entité.Questionnaire

class InteractionSourceQuestion {
    var sourceDeQuestion:SourceQuestion=SourceQuestion()
   fun obtenirQuestionInteracteur():Array<Questionnaire>{
       return sourceDeQuestion.obtenirQuestions()
   }
}