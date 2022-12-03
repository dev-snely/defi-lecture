package com.dti.defilecture.présentation.connexion

import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException
import com.dti.defilecture.présentation.connexion.IContratVPConnexion.IPrésentateurConnexion
import com.dti.defilecture.présentation.modèle
import kotlinx.coroutines.*

class PrésentateurConnexion(var vue: VueConnexion): IPrésentateurConnexion{

    override fun validerIdentifiants(pseudonyme:String,mdp:String) {

        //Ce bloc est exécuté dans le fil principal (GUI)
        GlobalScope.launch(Dispatchers.Main) {

            //Ce bloc est exécuté dans le fil IO
            var job = async(Dispatchers.IO) {
                //cette opération est longue
                modèle.connexion( pseudonyme, mdp )
            }
            //en attendant la fin de la tâche,
            //l'exécution de cette coroutine est suspendue
            try{
                var résultatConnexion : Boolean = job.await()

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