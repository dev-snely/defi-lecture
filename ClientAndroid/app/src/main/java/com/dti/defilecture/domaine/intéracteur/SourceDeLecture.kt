package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.domaine.entité.Lecture

/**
 * Interface qui oblige toute les sources de lecture à implémenter
 * les méthodes qu'elle contient
 */
interface SourceDeLecture {
    /**
     * Récupère une liste de lecture.
     */
    fun récupérerListeDeLecture(): List<Lecture>?

    /**
     * Ajoute un lecture aléatoire à la liste de lecture actuelle.
     */
    fun ajouterUneLecture( uneLecture: Lecture )
}