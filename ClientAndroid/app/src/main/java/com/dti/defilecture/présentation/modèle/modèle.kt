package com.dti.defilecture.présentation.modèle

import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.sourceDeDonnées.ajouterUneLecture

object modèle {

    lateinit var lecture: Lecture
    lateinit var compte: Compte

    fun ajouterLectureDansSourceDeDonnée(lecture: Lecture){
        ajouterUneLecture(lecture)
    }
    fun créationCompteDansSourceDeDonnée(compte: Compte){
        //À Faire
    }
}