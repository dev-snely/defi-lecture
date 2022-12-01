package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accèsAuxDonnées.lecture.ISourceDeLectures
import com.dti.defilecture.accèsAuxDonnées.lecture.SourceDeLectureBidons
import com.dti.defilecture.domaine.entité.Lecture

/**
 * Classe d'intéraction permettant la manipulation de lectures.
 */
class InteractionSourceDeLectures() {
    var sourceDeDonnées: ISourceDeLectures = SourceDeLectureBidons()
    var lecture: Lecture = Lecture("","",0, false)

    /**
     * Initialise un lecture à l'état vide.
     *
     * @return une lecture vide
     */
    fun initialiser(): Lecture{
        return lecture
    }

    /**
     *  Permet d'obtenir la liste de lecture d'une source de lectures.
     *
     *  @return une liste de lectures
     */
    fun obtenirListe(): MutableList< Lecture >?{
        return sourceDeDonnées.obtenirListeDeLecturesBidon()
    }

    /**
     *  Permet d'ajouter une lecture a une liste de lecture.
     *
     *  @param lecture une lecture à ajouter dans la source.
     */
    fun ajouterlecture( lecture: Lecture ){
        sourceDeDonnées.ajouterUneLectureALaListe( lecture )
    }
}