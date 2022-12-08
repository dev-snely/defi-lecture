package com.dti.defilecture.présentation.voirlectures

import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.*

class PrésentateurMesLectures(var vue: IVueMesLectures ) : IPrésentateurMesLectures {

    override fun initisaliseurDeLectures(): MutableList<Lecture>? {
        return modèle.obtenirListeLecturesDeLUtilisateur()
    }
}