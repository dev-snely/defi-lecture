package com.dti.defilecture.domaine.entité

class Compte(var idCompte: Int,
             var idEquipe: Int?,
             var prenom: String,
             var nom: String,
             var doublons: Int,
             var courriel: String,
             var pseudonyme: String,
             var programme: String,
             var role: Int,
             var motDePasse: String,
             var devenirCapitaine: Boolean,
             var avatar: String?) {

    constructor() : this(0,0,"","",0,"","","",0,
    "",false,null)

}