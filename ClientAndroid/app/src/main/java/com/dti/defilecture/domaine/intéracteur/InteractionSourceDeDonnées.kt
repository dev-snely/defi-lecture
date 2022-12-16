package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accèsAuxDonnées.ISourceDeDonnées
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.entité.Questionnaire
import com.dti.defilecture.domaine.entité.Équipage


/**
 * Classe d'intéraction qui permet de manipuler les objets puisés dans la source de données.
 */
class InteractionSourceDeDonnées( var sourceDeDonnées: ISourceDeDonnées ) {
    /**
     * Méthode qui permet de récupérer un Compte, puis d'initialiser la session
     * d'utilisation de l'utilisateur avec le compte récupéré.
     */
    fun récupérerComptePourConnexion( pseudo: String, mdp: String ): Compte?{
        return sourceDeDonnées.validerComptePourLaConnexion(pseudo,mdp)
    }
    /**
     * Initialise un lecture à l'état vide.
     *
     * @return une lecture vide
     */
    fun initialiserUneLectureIntéracteur(): Lecture {
        return Lecture("","",0,false)
    }

    /**
     *  Permet d'obtenir la liste de lecture d'une source de lectures.
     *
     *  @return une liste de lectures
     */
    fun obtenirListeDeLecturesIntéracteur(id: Int): MutableList<Lecture>?{
        return sourceDeDonnées.obtenirListeDeLecturesUtilisateurSource(id)
    }

    /**
     *  Permet d'ajouter une lecture a une liste de lecture.
     *
     *  @param lecture une lecture à ajouter dans la source.
     */
    fun ajouterUneLectureIntéracteur(lecture: Lecture){
        sourceDeDonnées.ajouterUneLectureALaListeSource( lecture )
    }

    /**
     *  Permet d'obtenir une liste des comptes d'un équipage.
     *
     *  @return une liste de comptes
     */
    fun obtenirListeDeComptesIntéracteur(nomÉquipage: String): MutableList<Compte>? {
        return sourceDeDonnées.obtenirListeDesComptesÉquipageSource(nomÉquipage)
    }

    /**
     * Méthode qui obtient des questions depuis la source de données.
     *
     * @returns Un tableau d'objets Questionnaire.
     */
    fun obtenirQuestionIntéracteur():Questionnaire{
        return sourceDeDonnées.obtenirQuestionSource()
    }

    /**
     *  Permet d'obtenir une liste des équipages.
     */
    fun obtenirListeDesÉquipagesIntéracteur(): MutableList<Équipage>?{
        return sourceDeDonnées.obtenirListeDesÉquipagesSource()
    }

    fun obtenirBonneReponseIntéracteur(questionnaire: Questionnaire): String {
        return sourceDeDonnées.obtenirBonneReponseSource(questionnaire)
    }
}