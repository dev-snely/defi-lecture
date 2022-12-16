package com.dti.defilecture.accèsAuxDonnées

import com.dti.defilecture.accèsAuxDonnées.lecture.date
import com.dti.defilecture.accèsAuxDonnées.lecture.formatter
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.entité.Questionnaire
import com.dti.defilecture.domaine.entité.Équipage

class SourceDeDonnéesBidon : ISourceDeDonnées {
    override fun validerComptePourLaConnexion( pseudo: String, mdp: String ): Compte? {
        var monCompte: Compte? = null

        for(compte in comptes){
            if ( compte.pseudonyme == pseudo && compte.motDePasse == mdp ) {
                monCompte= compte
            }
        }
        return monCompte
    }

    override fun obtenirListeDeLecturesUtilisateurSource(identifiant: Int): MutableList<Lecture>? {
        return lectures.sortedByDescending{ it.dateInscription }.toMutableList()
    }

    override fun ajouterUneLectureALaListeSource(lecture: Lecture) {
        lectures.add( lecture )
    }

    override fun obtenirQuestionSource(): Questionnaire {
        return Questionnaire()
    }

    override fun obtenirBonneReponseSource(questionnaire: Questionnaire): String {
        return questionnaire.bonneReponse
    }

    override fun obtenirÉquipageParNomÉquipage(nomÉquipage: String): Équipage {
        return équipages.first { it.nomÉquipage == nomÉquipage }
    }

    override fun obtenirListeDesComptesÉquipageSource(nomÉquipage: String): MutableList<Compte>? {
        return équipages.first { it.nomÉquipage == nomÉquipage }.listeComptes?.sortedByDescending{ it.doublons }?.toMutableList()
    }

    override fun obtenirListeDesComptesSource(): MutableList<Compte>? {
        TODO("Not yet implemented")
    }

    override fun obtenirListeDesÉquipagesSource(): MutableList<Équipage> {
        return équipages.sortedByDescending{ it.doublons }.toMutableList()
    }

    private var comptes : MutableList<Compte> = mutableListOf(
        Compte(1,"John", "Doe", 30,"john@gmail.com",
            "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
        Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
            "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
        Compte(3, "Snely", "Man", 60, "snel@gmail.com",
            "Jotaro", "Info","okokok", null, "unÉquipage")
    )

    private var équipages : MutableList<Équipage> = mutableListOf(
        Équipage(),
        Équipage( "Équipage 1", 10, 0,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
            "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
                Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                "Jotaro", "Info","okokok", null, "unÉquipage")
            )
        ),
        Équipage( "Équipage 2", 9, 15,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
                    "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                    "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
            )
        ),
        Équipage( "Équipage 3", 8, 30,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
                    "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                    "Jotaro", "Info","okokok", null, "unÉquipage")
            )
        ),
        Équipage( "Équipage 4", 7, 45,
            mutableListOf(
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                    "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
                Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                    "Jotaro", "Info","okokok",null, "unÉquipage")
            )
        ),
        Équipage( "Équipage 5", 6, 60,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
                    "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                    "Sparrow", "Administration", "blackpearl", null, "unÉquipage")
            )
        ),
        Équipage( "Équipage 6", 5, 75,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
                    "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                    "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
                Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                    "Jotaro", "Info","okokok",null, "unÉquipage")
            )
        ),
        Équipage( "Équipage 7", 4, 90,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
                    "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                    "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
                Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                    "Jotaro", "Info","okokok",null, "unÉquipage")
            )
        ),
        Équipage( "Équipage 8", 3, 105,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
                    "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                    "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
                Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                    "Jotaro", "Info","okokok", null, "unÉquipage")
            )
        ),
        Équipage( "Équipage 9", 2, 120,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
                    "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                    "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
                Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                    "Jotaro", "Info","okokok",null, "unÉquipage")
            )
        ),
        Équipage( "Équipage 10", 1, 135,
            mutableListOf(
                Compte(1,"John", "Doe", 30,"john@gmail.com",
                    "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
                Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                    "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
                Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                    "Jotaro", "Info","okokok",null, "unÉquipage")
            )
        )
    )
    private var lectures : MutableList<Lecture> = mutableListOf(
        Lecture("Alchimiste", formatter.format(date), 75, false),
        Lecture("Tartuffle", formatter.format(date), 45, true),
        Lecture("Tartuffle", formatter.format(date), 30, true),
        Lecture("Le Joueur", formatter.format(date), 60, false)
    )
    private val question1 = Questionnaire(
        1, "Dans l'article pirate,quels sont les deux ecrivains cites",
        "Balzac et Maupassant",
        "Baudelaire et Maupassant",
        "Balzac et Bossuet",
        "Bossuet et Baudelaire",
        "Balzac et Maupassant"
    )

    private val question2 = Questionnaire(
        2, "Identifiez le verbe qui est toujours intransif lorsqu'il est utiliser en navigation",
        "Dessaler",
        "Aborder",
        "Souquer",
        "Ferler",
        "Dessaler"
    )

    private val question3 = Questionnaire(
        3, "Dans le sens maritime du terme abattre,quel est l'antonyme",
        "Larguer",
        "Hisser",
        "Lofer",
        "Empanner",
        "Hisser"
    )

    private val question4 = Questionnaire(
        4, "A La Découverte de Louise Portal, dans quelle catégorie Louise Portal a-t-elle remporté un prix génie?",
        "Prix hommage ( Pour l'ensemble de sa carrière cinématographique ).",
        "Meilleure actrice de soutien ( Pour les invasions barbare )",
        "Meilleure actrice ( Pour Cordélia )",
        "Meilleure actrice de soutien ( Pour Le Déclin de L'empire américain )",
        "Meilleure actrice ( Pour Cordélia )"
    )
}