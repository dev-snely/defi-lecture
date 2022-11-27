package com.dti.defilecture.présentation.connexion

import com.dti.defilecture.présentation.connexion.IContratVPConnexion.IPrésentateurConnexion
import com.dti.defilecture.présentation.modèle

class PrésentateurConnexion(var vue: VueConnexion): IPrésentateurConnexion{

    override fun validerIdentifiants(pseudonyme:String,mdp:String) {
        if( modèle.connexion( pseudonyme, mdp ) ){
            vue.connexionReussi()
            vue.naviguerVersDefiLecture()
        }
        else{
            vue.connexionEchouer()
        }
    }
}