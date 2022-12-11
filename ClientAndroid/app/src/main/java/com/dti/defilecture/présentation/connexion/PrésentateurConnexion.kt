package com.dti.defilecture.présentation.connexion

import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException
import com.dti.defilecture.présentation.connexion.IContratVPConnexion.IPrésentateurConnexion
import com.dti.defilecture.présentation.modèle
import kotlinx.coroutines.*

class PrésentateurConnexion(var vue: VueConnexion): IPrésentateurConnexion{

    override fun validerIdentifiants(pseudonyme:String,mdp:String) {

        GlobalScope.launch(Dispatchers.Main) {

            val job = async(Dispatchers.IO) {
                modèle.connexion( pseudonyme, mdp )
            }
            //en attendant la fin de la tâche,
            //l'exécution de cette coroutine est suspendue
            try{
                val résultatConnexion : Boolean = job.await()

                if ( résultatConnexion ){
                    vue.connexionReussi()
                    vue.naviguerVersDefiLecture()
                }
                else {
                    vue.connexionEchouer()
                }
            }
            catch(e: AccèsRessourcesException){
                vue.connexionEchouer()
            }
        }
    }
}