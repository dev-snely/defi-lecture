package com.dti.defilecture.domaine.entité

/**
 * Entité compte qui représente la lecture d'un participant au Défi Lecture.
 */
class Lecture(var titreLecture: String,
              var dateInscription: String,
              var duréeMinutes: Int,
              var obligatoire: Boolean)
{
    /**
     * Second constructeur qui permet l'initialisation d'un compte sans information.
     */
    constructor() : this("","",0,false)
}
   /* var titreLecture: String = titre
    var dateInscription: String = date
    var duréeMinutes: Int = durée
    var obligatoire: Boolean? = obligatoire
}*/
