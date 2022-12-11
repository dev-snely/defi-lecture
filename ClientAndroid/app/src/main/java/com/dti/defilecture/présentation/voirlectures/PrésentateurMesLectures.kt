package com.dti.defilecture.présentation.voirlectures

import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PrésentateurMesLectures(var vue: IVueMesLectures ) : IPrésentateurMesLectures {

    override fun requêteRécupérationLecturesUtilisateurConnecté(): MutableList<Lecture>? {

        var listeLecture: MutableList<Lecture>? = null

        GlobalScope.launch(Dispatchers.Main) {
            val job = async(Dispatchers.IO) {
                modèle.obtenirListeLecturesDeLUtilisateur()
            }

            try{
                listeLecture = job.await()
            }
            catch(e: AccèsRessourcesException){
                //vue.afficherErreur()
            }
        }
        return listeLecture
    }
}