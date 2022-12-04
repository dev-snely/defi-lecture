package com.dti.defilecture.présentation.trésorerie

import com.dti.defilecture.domaine.entité.Équipage
import com.dti.defilecture.présentation.Modèle
import com.dti.defilecture.présentation.trésorerie.IContratVPTrésorerie.*

class PrésentateurTrésorerie(var modèle : Modèle, var vue: IVueTrésorerie):
    IPrésentateurTrésorerie {

    override fun initisaliseurDesÉquipages(): MutableList<Équipage>? {
        return modèle.obtenirListeDesÉquipages()
    }

}