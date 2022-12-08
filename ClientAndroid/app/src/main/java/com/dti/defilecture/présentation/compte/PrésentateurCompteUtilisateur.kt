package com.dti.defilecture.présentation.compte

import com.dti.defilecture.présentation.Modèle
import com.dti.defilecture.présentation.compte.IContratVPCompte.IVueCompteUtilisateur
import com.dti.defilecture.présentation.compte.IContratVPCompte.IPrésentateurCompteUtilisateur

class PrésentateurCompteUtilisateur(var modèle: Modèle,
                                    var vue: IVueCompteUtilisateur): IPrésentateurCompteUtilisateur {

    override fun requêteInitialiserCompte(){
        val compteActif = modèle.compteActif()
        vue.initCompte( compteActif.pseudonyme,compteActif.nom,compteActif.prénom,
            compteActif.courriel,compteActif.programme,compteActif.avatar)
    }



}