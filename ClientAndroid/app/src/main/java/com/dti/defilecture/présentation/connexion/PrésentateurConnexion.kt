package com.dti.defilecture.présentation.connexion

import com.dti.defilecture.présentation.connexion.IContratVPConnexion.IPrésentateurConnexion

class PrésentateurConnexion(var vue: VueConnexion): IPrésentateurConnexion{
    fun validerIdentifiant(){


    }

    override fun validerIdentifiants(pseudonyme:String,mdp:String) {
        if(pseudonyme=="admin" && mdp=="admin"){
            vue.connexionReussi()
        }
        else{
            vue.connexionEchouer()
        }
    }

}