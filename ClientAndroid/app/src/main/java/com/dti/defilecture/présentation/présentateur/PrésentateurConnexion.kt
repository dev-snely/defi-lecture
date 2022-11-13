package com.dti.defilecture.présentation.présentateur

import android.widget.Toast
import com.dti.defilecture.présentation.modèle.modèle
import com.dti.defilecture.présentation.vue.VueConnexion

class PrésentateurConnexion(var modele:modèle,var vue:VueConnexion){
    fun validerIdentifiant(pseudonyme:String,mdp:String){
        if(pseudonyme=="admin" && mdp=="admin"){
            vue.connexionReussi()
        }
        else{
            vue.connexionEchouer()
        }


    }

}