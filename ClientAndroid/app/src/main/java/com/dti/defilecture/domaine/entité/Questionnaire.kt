package com.dti.defilecture.domaine.entité

data class Questionnaire (
    val id :Int,
    val question:String,
    val rep_A:String,
    val rep_B: String,
    val rep_C: String,
    val rep_D: String,
    val Bonne_reponse:String
)


