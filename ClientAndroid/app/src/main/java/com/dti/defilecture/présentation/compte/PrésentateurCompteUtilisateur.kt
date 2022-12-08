package com.dti.defilecture.présentation.compte

import android.app.Activity
import android.graphics.Bitmap
import com.dti.defilecture.présentation.Modèle
import com.dti.defilecture.présentation.compte.IContratVPCompte.IVueCompteUtilisateur
import com.dti.defilecture.présentation.compte.IContratVPCompte.IPrésentateurCompteUtilisateur

class PrésentateurCompteUtilisateur(var modèle: Modèle,
                                    var vue: IVueCompteUtilisateur): IPrésentateurCompteUtilisateur {

    override fun requêteInitialiserCompte(){
        val compteActif = modèle.compteActif()
        vue.initCompte( compteActif.pseudonyme,compteActif.nom,compteActif.prenom,
            compteActif.courriel,compteActif.programme,compteActif.avatar)
    }



}