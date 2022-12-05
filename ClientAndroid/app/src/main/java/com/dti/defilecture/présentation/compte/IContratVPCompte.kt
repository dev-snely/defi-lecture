package com.dti.defilecture.présentation.compte

import com.dti.defilecture.R


interface IContratVPCompte {


    interface IVueCompte{
        /**
        *   Navigation vers la page de modification
         */
        fun naviguerVersModifier()

        /**
         *  Navigation vers le menu de compte
         */
        fun naviguerVersMenu()
    }

    interface IPrésentateurCompte{


    }


}