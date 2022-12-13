package com.dti.defilecture.présentation.voirlectures

import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.*
import kotlinx.coroutines.*

class PrésentateurMesLectures(var vue: IVueMesLectures, var vueAdapteur: VueMesLecturesAdaptateur ) : IPrésentateurMesLectures {

    override fun requêteRécupérationLecturesUtilisateurConnecté() {

        GlobalScope.launch(Dispatchers.Main) {

            val job = async(SupervisorJob() + Dispatchers.IO) {
                modèle.obtenirListeLecturesDeLUtilisateur()
            }

            //en attendant la fin de la tâche,
            //l'exécution de cette coroutine est suspendue
            try{
                var listeLecture = job.await()

                if ( listeLecture.isNotEmpty() ){
                    vueAdapteur.lectures = listeLecture
                }
            }
            catch(e: AccèsRessourcesException){
                //vue.afficherErreurDExecution()
            }
        }
    }
}