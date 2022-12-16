package com.dti.defilecture.domaine.entité

/**
 * Entité questionnaire qui représente un mini défi pour les participants au Défi Lecture.
 * Si un participant s'avérait à répondre correctement questionnaire, il gagnerait des points supplémentaire
 * pour son équipe.
 */
class Questionnaire (
    var id :Int,
    var question:String,
    var rep_A:String,
    var rep_B: String,
    var rep_C: String,
    var rep_D: String,
    var bonneReponse:String)
{
    /**
     * Second constructeur qui permet l'initialisation d'un compte sans information.
     */
    constructor() : this(0,"","","","","","" )
}


