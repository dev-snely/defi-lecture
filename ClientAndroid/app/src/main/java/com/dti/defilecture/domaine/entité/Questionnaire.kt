package com.dti.defilecture.domaine.entité

/**
 * Entité questionnaire qui représente un mini défi pour les participants au Défi Lecture.
 * Si un participant s'avérait à répondre correctement questionnaire, il gagnerait des points supplémentaire
 * pour son équipe.
 */
data class Questionnaire (
    val id :Int,
    val question:String,
    val rep_A:String,
    val rep_B: String,
    val rep_C: String,
    val rep_D: String,
    val Bonne_reponse:String
)


