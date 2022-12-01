package com.dti.defilecture.présentation.trésorerie

import com.dti.defilecture.accèsAuxDonnées.lecture.Remplir
import com.dti.defilecture.présentation.Modèle

class PrésentateurTrésorerie(var modèle : Modèle, var vue: ContratVuePrésentateurTrésorerie.IVueTrésorerie):
    ContratVuePrésentateurTrésorerie.IPrésentateurTrésorerie {

    init {
        Remplir()
    }

}