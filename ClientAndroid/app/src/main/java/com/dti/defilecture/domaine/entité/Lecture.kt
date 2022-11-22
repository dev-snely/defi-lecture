package com.dti.defilecture.domaine.entité

class Lecture {

    var titreLecture: String = ""
    var dateInscription: String = ""
    var duréeMinutes: Int = 0
    var obligatoire: Boolean? = null

    init{}

    constructor( titre: String, date: String, durée: Int, obligatoire: Boolean ){
        this.titreLecture = titre
        this.dateInscription = date
        this.duréeMinutes = duréeMinutes
        this.obligatoire = obligatoire
    }
}
