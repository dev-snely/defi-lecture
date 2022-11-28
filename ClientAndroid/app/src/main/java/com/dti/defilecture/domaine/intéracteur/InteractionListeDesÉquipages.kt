package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accesAuxDonnees.ISourcesDeLectures
import com.dti.defilecture.accesAuxDonnees.SourceDeLectureBidons
import com.dti.defilecture.domaine.entité.Lecture

class InteractionListeDesÉquipages(  ) {


    var sourceDeDonnées: ISourcesDeLectures = SourceDeLectureBidons()

    var lecture: Lecture = Lecture("","",0, false)

    /**
    Initialise une lecture en la rendant vide lorsque
    l'utilisateur décide d'ajouter une lecture.

    @param lecture La lecture qui sera ajouter dans la liste de lecture de l'utilisateur
     */
    fun initialiser(): Lecture{
        return lecture
    }

    /**
     *  Permet d'obtenir une liste de lecture.
     */
    fun obtenirListe(): MutableList< Lecture >?{
        return sourceDeDonnées.obtenirListeDeLecturesDUnUtilisateur()
    }

    /**
     *  Permet d'ajouter une lecture a une liste de lecture.
     */
    fun ajouterlecture( lecture: Lecture ){
        sourceDeDonnées.ajouterUneLectureALaListe( lecture )
    }



}