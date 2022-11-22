package com.dti.defilecture.présentation.bienvenue



interface IContratVPBienvenue {

    interface IVueBienvenue{
        fun naviguerVersPageDInscription()
        fun naviguerVersPageDeConnexion()
    }
    interface IPrésentateurBienvenue{
        fun naviguerVersPageDInscription()
        fun naviguerVersPageDeConnexion()
    }


}