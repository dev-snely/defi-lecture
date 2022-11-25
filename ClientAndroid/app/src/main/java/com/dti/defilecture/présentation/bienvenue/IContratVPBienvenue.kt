package com.dti.defilecture.présentation.bienvenue

interface IContratVPBienvenue {
    interface IVueBienvenue{
        fun naviguerVersInscription()
        fun naviguerVersConnexion()
    }

    interface IPrésentateurBienvenue{
        fun naviguerVersPageDInscription()
        fun naviguerVersPageDeConnexion()
    }
}