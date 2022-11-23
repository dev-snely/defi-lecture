package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accesAuxDonnees.ISourcesDeLectures
import com.dti.defilecture.domaine.entité.Lecture

class AjouterLectureDUnUtilisateur( var sourceDeDonnées: ISourcesDeLectures ) {

    fun ajouterlecture( lecture: Lecture ){
        sourceDeDonnées.ajouterUneLectureALaListe( lecture )
    }

}