package com.dti.defilecture.présentation.compteTemporaire

import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.compteUtilisateur.IContratVPCompteTemporaire.IVueCompteTemporaire
import com.dti.defilecture.présentation.compteUtilisateur.IContratVPCompteTemporaire.IPrésentateurCompteTemporaire

class PrésentateurCompteTemporaire(var vue: IVueCompteTemporaire): IPrésentateurCompteTemporaire {

    override fun initialiserCompteTemporaire(): Compte {
        return modèle.compteActif()
    }
}