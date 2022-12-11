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
    fun initialiserUneLecture(): Lecture {
        return Lecture("","",0,false)
    }

    /**
     *  Permet d'obtenir la liste de lecture d'une source de lectures.
     *
     *  @return une liste de lectures
     */
    fun obtenirListeDeLectures(id: Int): MutableList<Lecture>?{
        return sourceDeDonnées.obtenirListeDeLecturesUtilisateur(id)
    }

    /**
     *  Permet d'ajouter une lecture a une liste de lecture.
     *
     *  @param lecture une lecture à ajouter dans la source.
     */
    fun ajouterUneLecture( lecture: Lecture){
        sourceDeDonnées.ajouterUneLectureALaListe( lecture )
    }

    /**
     *  Permet d'obtenir une liste des comptes d'un équipage.
     *
     *  @return une liste de comptes
     */
    fun obtenirListeDeComptes(nomÉquipage: String): MutableList<Compte>? {
        return sourceDeDonnées.obtenirListeDesComptes(nomÉquipage)
    }

    /**
     * Méthode qui obtient des questions depuis la source de données.
     *
     * @returns Un tableau d'objets Questionnaire.
     */
    fun obtenirQuestions():Array<Questionnaire>{
        return sourceDeDonnées.obtenirQuestions()
    }

    /**
     *  Permet d'obtenir une liste des équipages.
     */
    fun obtenirListeDesÉquipages(): MutableList<Équipage>?{
        return sourceDeDonnées.obtenirListeDesÉquipages()
    }
}