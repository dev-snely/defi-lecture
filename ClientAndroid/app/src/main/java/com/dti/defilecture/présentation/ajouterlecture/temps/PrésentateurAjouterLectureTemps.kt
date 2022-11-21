package com.dti.defilecture.présentation.ajouterlecture.temps


import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IVueAjouterLectureTemps
import com.dti.defilecture.présentation.ajouterlecture.temps.IContratVPAjouterLectureTemps.IPrésentateurAjouterLectureTemps


class PrésentateurAjouterLectureTemps(var modèle : modèle,
                                      var vue: IVueAjouterLectureTemps): IPrésentateurAjouterLectureTemps {
    override fun traiterAjouterMinutes(minuteAAjouter: Int, texteAuCompteur: String) {
        TODO("Not yet implemented")
    }

    override fun traiterReinitialisationCompteur() {
        TODO("Not yet implemented")
    }

}