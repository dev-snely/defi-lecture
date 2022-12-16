package com.dti.defilecture.accèsAuxDonnées

import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.entité.Questionnaire
import com.dti.defilecture.domaine.entité.Équipage

/**
 * Interface qui définit ce qu'une source de données pour le défi lecture est capable de retourner
 * comme information la concernant.
 */
interface ISourceDeDonnées {
    /**
     * Méthode qui permet de valider si un compte existe pour s'identifier, puis s'y connecter.
     *
     * @param pseudo pseudonyme de l'utilisateur.
     * @param mdp mot de passe de l'utilisateur.
     */
    fun validerComptePourLaConnexion( pseudo : String, mdp : String ): Compte?

    /**
     * Méthode qui permet d'obtenir la liste des comptes d'un équipage
     */
    fun obtenirListeDesComptesÉquipageSource(nomÉquipage: String): MutableList<Compte>?

    /**
     * Méthode qui retourne la liste de lecture de l'utilisateur.
     *
     * @return Une liste mutable d'objets lectures.
     */
    fun obtenirListeDeLecturesUtilisateurSource(identifiant: Int ) : MutableList<Lecture>?
    /**
     * Méthode qui ajoute une lecture à une liste de lectures bidon.
     *
     * @param lecture Une lecture à ajouter.
     */
    fun ajouterUneLectureALaListeSource(lecture: Lecture)
    /**
     * Cette méthode permet d'obtenir quatre question contenant chacune leur réponse.
     *
     * @return Un tableau d'objets Questionnaire.
     */
    fun obtenirQuestionSource(): Questionnaire


    fun obtenirBonneReponseSource(questionnaire: Questionnaire): String


    /**
     *  Cette méthode permet l'obtention d'une liste d'équipages participants au Défi Lecture.
     */
    fun obtenirListeDesÉquipagesSource() : MutableList<Équipage>?
}