package com.dti.defilecture.accèsAuxDonnées.lecture

import com.dti.defilecture.domaine.entité.Lecture

/**
 * Interface qui définit ce qu'une source de lecture possède comme méthode.
 */
interface ISourceDeLectures {
    /**
     * Méthode qui retourne une liste de lectures bidon.
     *
     * @return Une liste mutable d'objets lectures.
     */
    fun obtenirListeDeLecturesBidon() : MutableList<Lecture>?
    /**
     * Méthode qui ajoute une lecture à une liste de lectures bidon.
     *
     * @param lecture Une lecture à ajouter.
     */
    fun ajouterUneLectureALaListe( lecture: Lecture )
}