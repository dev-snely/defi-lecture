package com.dti.defilecture.présentation.connexion

import com.dti.defilecture.présentation.connexion.IContratVPConnexion.IPrésentateurConnexion

class PrésentateurConnexion(var vue: VueConnexion): IPrésentateurConnexion{

    override fun validerIdentifiants(pseudonyme:String,mdp:String) {
        if(pseudonyme=="" && mdp==""){
            vue.connexionReussi()
            vue.naviguerVersDefiLecture()
        }
        else{
            vue.connexionEchouer()
        }
    }
}