package com.dti.defilecture.présentation.modifier

interface IContratVPModifier {

    interface IVueModifer{
        fun naviguerVersMonCompte()
        fun initModifier(pseudonyme:String, nom: String, prénom: String,
                         courriel: String, programme: String)
    }

    interface IPrésentateurModifer{
        /**
         * Requête pour initiliser les infos dans la modification
         */
        fun requêteInitialiserCompte()

        /**
         *
         */
        fun enregistrerInfo(pseudonyme: String,prénom: String,
                            nom: String,courriel: String,programme: String)
    }



}