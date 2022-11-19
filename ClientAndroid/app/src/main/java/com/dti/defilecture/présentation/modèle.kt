package com.dti.defilecture.présentation

import com.dti.defilecture.accesAuxDonnees.SourceDeLectureBidons
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.intéracteur.ObtenirListeDeLecturesDUnUtilisateur

object modèle {

    lateinit var lecture: Lecture


    fun ajouterLectureDansSourceDeDonnée(lecture: Lecture){
        ajouterLectureDansSourceDeDonnée(lecture)
    }

    /**
    Récupère la liste des lectures de l'utilisateur avec l'intéracteur
     */
    fun obtenirListeLecturesDeLUtilisateur(): MutableList<Lecture>?  {
        return ObtenirListeDeLecturesDUnUtilisateur( SourceDeLectureBidons() ).obtenirListe()
    }
}