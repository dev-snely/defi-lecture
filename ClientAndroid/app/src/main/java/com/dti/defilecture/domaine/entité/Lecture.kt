package com.dti.defilecture.domaine.entité

class Lecture(titre: String, date: String, durée: Int, obligatoire: Boolean) {

    var titreLecture: String = titre
    var dateInscription: String = date
    var duréeMinutes: Int = durée
    var obligatoire: Boolean? = obligatoire

    init{}

}
