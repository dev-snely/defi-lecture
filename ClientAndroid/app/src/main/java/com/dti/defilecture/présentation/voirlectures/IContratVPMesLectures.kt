package com.dti.defilecture.présentation.voirlectures

import com.dti.defilecture.domaine.entité.Lecture

interface IContratVPMesLectures {

    interface IVueMesLectures{
        fun naviguerVersAjoutTitreLecture()
    }

    interface IPrésentateurMesLectures{
        fun initisaliseurDeLectures(): MutableList<Lecture>?
    }
}