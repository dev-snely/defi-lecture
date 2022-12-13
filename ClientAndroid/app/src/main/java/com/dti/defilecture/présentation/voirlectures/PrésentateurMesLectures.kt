package com.dti.defilecture.présentation.voirlectures

import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.*
import kotlinx.coroutines.*

class PrésentateurMesLectures(var vue: IVueMesLectures ) : IPrésentateurMesLectures {

    override fun requêteRécupérationLecturesUtilisateurConnecté() {
        GlobalScope.launch(Dispatchers.Main) {

            val job = async(SupervisorJob() + Dispatchers.IO) {
                modèle.obtenirListeLecturesDeLUtilisateur()
            }

            try {
                var listeLecture = job.await()

                //lorsque la tâche est terminée, la coroutine
                //reprend et on met à jour l'interface utilisateur
                //vue.effacerLecture();
                vue.gestionAfficherLecture(listeLecture)
            }
            catch(e: AccèsRessourcesException){
                vue.afficherMessageErreurInternet()
            }
        }
    }

    override fun requêteNaviguerVersAjoutTitreLecture() {
        vue.naviguerVersAjoutTitreLecture()
    }
}