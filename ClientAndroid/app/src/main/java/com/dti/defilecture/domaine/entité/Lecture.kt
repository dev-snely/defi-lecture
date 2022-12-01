package com.dti.defilecture.domaine.entité

/**
 * Entité compte qui représente la lecture d'un participant au Défi Lecture.
 */
class Lecture(titre: String, date: String, durée: Int, obligatoire: Boolean) {

    var titreLecture: String = titre
    var dateInscription: String = date
    var duréeMinutes: Int = durée
    var obligatoire: Boolean? = obligatoire

}
