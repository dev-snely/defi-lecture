package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Questionnaire

class SourceQuestion {
    fun obtenirQuestions():Array<Questionnaire> {
        val question1 = Questionnaire(
            1, "Dans l'article pirate,quels sont les deux ecrivains cites",
            "Balzac et Maupassant",
            "Baudelaire et Maupassant",
            "Balzac et Bossuet",
            "Bossuet et Baudelaire",
            "Balzac et Maupassant"
        )

        val question2 = Questionnaire(
            2, "Identifiez le verbe qui est toujours intransif lorsqu'il est utiliser en navigation",
            "Dessaler",
            "Aborder",
            "Souquer",
            "Ferler",
            "Dessaler"
        )

        val question3 = Questionnaire(
            3, "Dans le sens maritime du terme abattre,quel est l'antonyme",
            "Larguer",
            "Hisser",
            "Lofer",
            "Empanner",
            "Hisser"
        )

        val question4 = Questionnaire(
            4, "A La Découverte de Louise Portal, dans quelle catégorie Louise Portal a-t-elle remporté un prix génie?",
            "Prix hommage ( Pour l'ensemble de sa carrière cinématographique ).",
            "Meilleure actrice de soutien ( Pour les invasions barbare )",
            "Meilleure actrice ( Pour Cordélia )",
            "Meilleure actrice de soutien ( Pour Le Déclin de L'empire américain )",
            "Meilleure actrice ( Pour Cordélia )"
        )
        val liste_question = arrayOf(question1,question2,question3,question4)
        return liste_question
    }
}