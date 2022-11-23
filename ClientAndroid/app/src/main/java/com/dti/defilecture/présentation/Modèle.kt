package com.dti.defilecture.présentation

import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.intéracteur.InteractionListeDeLecturesDUnUtilisateur
import java.text.SimpleDateFormat
import java.util.*

class Modèle() {

    private var lecture =  Lecture("","",0,false)

    fun ajouterLectureDansSourceDeDonnée(){
        val aujourdhui = Calendar.getInstance().time
        val adapteur = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        lecture.dateInscription = adapteur.format(aujourdhui)

        InteractionListeDeLecturesDUnUtilisateur().ajouterlecture( lecture )
    }

    /**
    Récupère la liste des lectures de l'utilisateur avec l'intéracteur
     */
    fun obtenirListeLecturesDeLUtilisateur(): MutableList<Lecture>?  {
        return InteractionListeDeLecturesDUnUtilisateur().obtenirListe()
    }

    /**
     *  Initialise une lecture vide
     */
    fun initialiserLecture(){
        lecture = InteractionListeDeLecturesDUnUtilisateur().initialiser()
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


}
val modèle = Modèle()