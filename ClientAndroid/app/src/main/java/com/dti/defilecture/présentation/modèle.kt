package com.dti.defilecture.présentation

import com.dti.defilecture.accèsAuxDonnées.compte.ISourceDeComptes
import com.dti.defilecture.accèsAuxDonnées.compte.SourceDeComptesBidons
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.entité.Questionnaire
import com.dti.defilecture.domaine.entité.Équipage
import com.dti.defilecture.domaine.intéracteur.*
import java.text.SimpleDateFormat
import java.util.*

class Modèle(var sourceDeCompte : ISourceDeComptes = SourceDeComptesBidons()) {

    private var lecture =  Lecture("","",0,false)
    private var compteConnecté = Compte()

    fun ajouterLectureDansSourceDeDonnée(){
        val aujourdhui = Calendar.getInstance().time
        val adapteur = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        lecture.dateInscription = adapteur.format(aujourdhui)

        InteractionSourceDeLectures().ajouterlecture( lecture )
    }

    /**
    Récupère la liste des lectures de l'utilisateur avec l'intéracteur
     */
    fun obtenirListeLecturesDeLUtilisateur(): MutableList<Lecture>?  {
        return InteractionSourceDeLectures().obtenirListe()
    }

    /**
     *  Initialise une lecture vide
     */
    fun initialiserLecture(){
        lecture = InteractionSourceDeLectures().initialiser()
    }

    /**
     * Ajoute un titre a la lecture
     */
    fun ajouterTitreAUneLecture(titre: String){
        lecture.titreLecture = titre
    }

    /**
     * Ajoute un temps de lecture a la lecture
     */
    fun ajouterTempsAUneLecture(durée: Int){
        lecture.duréeMinutes = durée
    }
    /**
     * Ajoute une obligation  la lecture
     */
    fun ajouterObligationAUneLecture(obligation: Boolean){
        lecture.obligatoire = obligation
    }

    /**
     * Renvoie vrai si la lecture est manquante.
     */
    fun verifierLectureTitreManquant(): Boolean{
        return lecture.titreLecture.isEmpty()
    }

    /**
     * Renvoie vrai si la lecture n'a aucune minutes d'entrée.
     */
    fun verifierLectureDureeManquante(): Boolean{
        return lecture.duréeMinutes == 0
    }

    /**
     * Renvoie vrai si la lecture n'est ni obligatoire, ni non obligatoire.
     */
    fun verifierLectureObligation(): Boolean{
        return lecture.obligatoire == null
    }
    fun obtenirListeQuestion(): Array<Questionnaire>{
        return InteractionSourceDeQuestions().obtenirQuestionInteracteur()
    }

    /**
     * Établis la connexion et initialise le compte connecté selon le compte retourné depuis la source
     * lorsque les bons identifiants ont été entré.
     */
    fun connexion(pseudo: String, mdp: String): Boolean{
        var connexion = false
        val unCompte: Compte? = InteractionSourceDeComptes( sourceDeCompte ).récupérerComptePourConnexion( pseudo, mdp )
        if( unCompte != null ){
            compteConnecté = unCompte
            connexion = true
        }
        return connexion
    }

    fun créationCompteDansSourceDeDonnée(compte: Compte){
        //À Faire
    }

    fun obtenirListeDesComptesÉquipage(): MutableList<Compte>? {
        return InteractionListeDesComptesÉquipage().obtenirListe()
    }

    fun obtenirListeDesÉquipages(): MutableList<Équipage>?{
        return InteractionListeDesÉquipages().obtenirListe()
    }
}
val modèle = Modèle()
