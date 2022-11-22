package com.dti.defilecture.présentation.bienvenue

import com.dti.defilecture.présentation.bienvenue.IContratVPBienvenue.IPrésentateurBienvenue
import com.dti.defilecture.présentation.bienvenue.IContratVPBienvenue.IVueBienvenue

class PrésentateurBienvenue(var vue: IVueBienvenue) : IPrésentateurBienvenue {

    override fun naviguerVersPageDInscription() {
        vue.naviguerVersPageDInscription()
    }

    override fun naviguerVersPageDeConnexion() {
        vue.naviguerVersPageDeConnexion()
    }

}