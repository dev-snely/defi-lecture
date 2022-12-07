package com.dti.defilecture.présentation.trésorerie

import android.util.Log
import com.dti.defilecture.domaine.entité.Équipage
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.trésorerie.IContratVPTrésorerie.*

class PrésentateurTrésorerie(var vue: IVueTrésorerie):
    IPrésentateurTrésorerie {

    override fun initisaliseurDesÉquipages(): MutableList<Équipage>? {
        return modèle.obtenirListeDesÉquipages()
    }

    override fun requêteVoirDétailsÉquipage(nomÉquipage: String) {
        modèle.initialiserÉquipage(nomÉquipage)
        vue.naviguerVersDétailsÉquipage()
    }
}