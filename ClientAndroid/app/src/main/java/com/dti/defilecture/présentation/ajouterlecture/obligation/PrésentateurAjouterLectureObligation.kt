package com.dti.defilecture.présentation.ajouterlecture.obligation


import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.ajouterlecture.obligation.IContratVPAjouterLectureObligation.IPrésentateurAjouterLectureObligation
import com.dti.defilecture.présentation.ajouterlecture.obligation.IContratVPAjouterLectureObligation.IVueAjouterLectureObligation


class PrésentateurAjouterLectureObligation(var modèle : modèle,
                                      var vue: IVueAjouterLectureObligation): IPrésentateurAjouterLectureObligation {
    override fun traiterObligationDeLecture() {
        TODO("Not yet implemented")
    }

    override fun traiterAjouterLecture(
        titre: String,
        minutes: Int,
        obligation: Boolean,
        lectureObligé: Boolean
    ) {
        TODO("Not yet implemented")
    }

}