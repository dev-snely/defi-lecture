package com.dti.defilecture.présentation.modèle

import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.sourceDeDonnées.ajouterUneLecture

object modèle {

    lateinit var lecture: Lecture

    fun ajouterLectureDansSourceDeDonnée(lecture: Lecture){
        ajouterUneLecture(lecture)
    }
}