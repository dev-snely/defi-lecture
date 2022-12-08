package com.dti.defilecture.domaine.entité

/**
 * Entité Équipage qui représente l'équipage d'un capitaine au Défi Lecture.
 */
class Équipage(var nomÉquipage: String, var rang: Int,
               var doublonsÉquipage: Int, var listeComptes: MutableList<Compte>){

    /**
     * Second constructeur qui permet l'initialisation d'un compte sans information.
     */
    constructor() : this("",0,0, mutableListOf())
}