package com.dti.defilecture.domaine.entité

import android.graphics.Bitmap


/**
 * Entité compte qui représente les informations d'un participant au Défi Lecture.
 */
class Compte(
    var idCompte: Int,
    var prénom: String,
    var nom: String,
    var doublons: Int,
    var courriel: String,
    var pseudonyme: String,
    var programme: String,
    var motDePasse: String,
    var avatar: Bitmap?,
    var nomÉquipage: String
) {

    /**
     * Second constructeur qui permet l'initialisation d'un compte sans information.
     */
    constructor() : this(0, "","",0,"","","",
    "",null, "")

}