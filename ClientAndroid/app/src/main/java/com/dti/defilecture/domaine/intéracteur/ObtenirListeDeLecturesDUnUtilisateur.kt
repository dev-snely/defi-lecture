package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accesAuxDonnees.ISourcesDeLectures
import com.dti.defilecture.domaine.entité.Lecture

class ObtenirListeDeLecturesDUnUtilisateur( var sourceDeDonnées: ISourcesDeLectures ) {

    fun obtenirListe(): MutableList< Lecture >?{
        return sourceDeDonnées.obtenirListeDeLecturesDUnUtilisateur()
    }

}