package com.dti.defilecture.présentation.présentateur

import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurÉquipage
import com.dti.defilecture.présentation.modèle.Modèle
import com.dti.defilecture.sourceDeDonnées.*

class PrésentateurÉquipage(var modèle : Modèle, var vue: ContratVuePrésentateurÉquipage.IVueÉquipage):
    ContratVuePrésentateurÉquipage.IPrésentateurÉquipage {

    init {
        Remplir()
    }


}