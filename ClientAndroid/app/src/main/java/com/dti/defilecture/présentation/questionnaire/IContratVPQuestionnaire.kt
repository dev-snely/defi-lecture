package com.dti.defilecture.présentation.questionnaire

interface IContratVPQuestionnaire {

    interface IVueQuestionnaire{
        fun afficherBonneReponse()
        fun afficherMauvaiseReponse()
    }

    interface IPrésentateurQuestionnaire{
        fun getQuestion():String
        fun getReponseA():String
        fun getReponseB():String
        fun getReponseC():String
        fun getReponseD():String
        fun bonneReponse(reponseChoisi :String)
    }

}