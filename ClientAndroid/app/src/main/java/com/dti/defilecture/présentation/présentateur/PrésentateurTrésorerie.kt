package com.dti.defilecture.présentation.présentateur

import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurTrésorerie
import com.dti.defilecture.présentation.modèle.Modèle
import com.dti.defilecture.sourceDeDonnées.*

class PrésentateurTrésorerie(var modèle : Modèle, var vue: ContratVuePrésentateurTrésorerie.IVueTrésorerie):
    ContratVuePrésentateurTrésorerie.IPrésentateurTrésorerie {

    init {
        Remplir()
    }

}