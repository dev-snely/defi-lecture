package com.dti.defilecture.présentation.menu

interface IContratVPMenu{
    interface IVueMenu{
        /**
         * Requête qui demande le changement vers le fragment Langage
         */
        fun naviguerVersPageLangage()
        /**
         * Requête qui demande le changement vers le fragment Glossaire
         */
        fun naviguerVersPageGlossaire()
        /**
         * Requête qui demande le changement vers le fragment À Propos
         */
        fun naviguerVersPageAPropos()
        /**
         * Requête qui demande le changement vers le fragment Connexion
         */
        fun deconnexion()
    }

    interface IPrésentateurMenu{
        /**
         * Requête qui envoie la requête pour changer le fragement vers Langage
         */
        fun requêteNaviguerVersPageLangage()
        /**
         * Requête qui envoie la requête pour changer le fragement vers Glossaire
         */
        fun requêteNaviguerVersPageGlossaire()
        /**
         * Requête qui envoie la requête pour changer le fragement vers À propos
         */
        fun requêteNaviguerVersPageAPropos()
        /**
         * Requête qui envoie la requête pour changer le fragement vers Connexion
         */
        fun requêteDeconnexion()
    }
}