package com.dti.defilecture.présentation.connexion

interface IContratVPConnexion {
    interface IVueConnexion{
        fun connexionReussi()
        fun connexionEchouer()
        fun naviguerVersDefiLecture()
        /**
        * Indique a l'utilisateur quoi faire pour modifier son mot de passe
        */
        fun MessageMotDePasseOublié()
    }
    interface IPrésentateurConnexion{
        fun validerIdentifiants( pseudonyme:String, mdp:String )
    }
}