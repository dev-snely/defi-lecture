package com.dti.defilecture.présentation.équipage

import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.IVueÉquipage
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.*

class PrésentateurÉquipage(var vue: IVueÉquipage):
    IPrésentateurÉquipage {

    override fun initisaliseurDesComptes(nomÉquipage: String): MutableList<Compte>? {
        return modèle.obtenirListeDesComptes(nomÉquipage)
    }

    override fun requêteVoirDétailsCompte(position: Int) {
        vue.naviguerVersDétailsCompte(position)
    }
}