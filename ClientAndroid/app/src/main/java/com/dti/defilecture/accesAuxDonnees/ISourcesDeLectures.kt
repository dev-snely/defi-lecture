package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Lecture

interface ISourcesDeLectures {
    fun obtenirListeDeLecturesDUnUtilisateur() : MutableList<Lecture>?
    fun ajouterUneLectureALaListe( lecture: Lecture )
}