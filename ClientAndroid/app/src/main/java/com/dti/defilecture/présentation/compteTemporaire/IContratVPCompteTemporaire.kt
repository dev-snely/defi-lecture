package com.dti.defilecture.présentation.compteUtilisateur

import android.graphics.Bitmap
import com.dti.defilecture.domaine.entité.Compte

interface IContratVPCompteTemporaire {

    interface IVueCompteTemporaire{
        fun naviguerVersDétailsCompte(pseudonyme: String)
    }

    interface IPrésentateurCompteTemporaire{
        /**
         * Requête pour initiliser les information du fragment compte
         */
        fun initialiserCompteTemporaire(): Compte
    }


}