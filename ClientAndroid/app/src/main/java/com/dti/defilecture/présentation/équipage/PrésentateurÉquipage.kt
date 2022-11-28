package com.dti.defilecture.présentation.équipage

import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.Modèle
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.IVueÉquipage

class PrésentateurÉquipage(var modèle: Modèle, var vue: IVueÉquipage ):
    IContratVPÉquipage.IPrésentateurÉquipage {

    override fun initisaliseurDesComptes(): MutableList<Compte>? {
        return modèle.obtenirListeDesComptesÉquipage()
    }


}