package com.dti.defilecture.présentation.équipageTemporaire

import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.équipageTemporaire.IContratVPÉquipageTemporaire.*

class PrésentateurÉquipageTemporaire (var vue: IVueÉquipageTemporaire): IPrésentateurÉquipageTemporaire {

    override fun initisaliseurDesComptesTemporaires(nomÉquipage : String): MutableList<Compte>? {
        return modèle.obtenirListeDesComptesÉquipageTemporaire(nomÉquipage)
    }

    override fun requêteVoirDétailsCompteTemporaire(pseudonyme: String, nomÉquipage: String) {
        modèle.initialiserCompte(pseudonyme, nomÉquipage)
        if (pseudonyme == modèle.compteActif().pseudonyme) {
            vue.naviguerVersDétailsCompteActif()
        } else {
            vue.naviguerVersDétailsCompteTemporaire()
        }
    }
}