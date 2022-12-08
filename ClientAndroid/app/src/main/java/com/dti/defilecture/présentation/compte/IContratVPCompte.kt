package com.dti.defilecture.présentation.compte

import android.graphics.Bitmap

interface IContratVPCompte {


    interface IVueCompteUtilisateur{
        /**
        *   Navigation vers la page de modification
         */
        fun naviguerVersModifier()

        /**
         *  Navigation vers le menu de compte
         */
        fun naviguerVersMenu()
        /**
         * Fonction qui affice les information du compte
         */
        fun initCompte(
            pseudonyme:String, nom: String, prénom: String,
            courriel: String, programme: String, avatar: Bitmap?
        )
    }

    interface IPrésentateurCompteUtilisateur{

        /**
         * Requête pour initiliser les information du fragment compte
         */
        fun requêteInitialiserCompte()


    }


}