package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Lecture

interface ISourcesDeLectures {
    /**
     * Méthode qui retourne une liste de lectures bidon.
     */
    fun obtenirListeDeLecturesBidon() : MutableList<Lecture>?
    /**
     * Méthode qui ajoute une lecture à une liste de lectures bidon.
     */
    fun ajouterUneLectureALaListe( lecture: Lecture )
}