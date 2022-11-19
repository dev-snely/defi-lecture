package com.dti.defilecture.présentation.voirlectures

import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.IVueMesLectures
import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.IPrésentateurMesLectures

class PrésentateurMesLectures( var modèle: modèle,
                               var vue: IVueMesLectures ) : IPrésentateurMesLectures {

    override fun initisaliseurDeLectures(): MutableList<Lecture>? {
        return modèle.obtenirListeLecturesDeLUtilisateur()
    }
}