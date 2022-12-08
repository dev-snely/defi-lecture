package com.dti.defilecture.présentation.modifier

import com.dti.defilecture.présentation.Modèle
import com.dti.defilecture.présentation.modifier.IContratVPModifier.IVueModifer
import com.dti.defilecture.présentation.modifier.IContratVPModifier.IPrésentateurModifer

class PrésentateurModifier(var modèle: Modèle,
                           var vue: IVueModifer): IPrésentateurModifer {
    val compteActif = modèle.compteActif()
    override fun requêteInitialiserCompte(){
        vue.initModifier( compteActif.pseudonyme,compteActif.nom,compteActif.prénom,
            compteActif.courriel,compteActif.programme)
    }

    override fun enregistrerInfo(pseudonyme: String, prenom: String,
                                 nom: String, courriel: String, programme: String){
        compteActif.pseudonyme = pseudonyme
        compteActif.nom = nom
        compteActif.prénom = prenom
        compteActif.courriel = courriel
        compteActif.programme = programme

    }

}