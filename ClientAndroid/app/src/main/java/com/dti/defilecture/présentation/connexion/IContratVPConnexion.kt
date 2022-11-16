package com.dti.defilecture.présentation.connexion

interface IContratVPConnexion {
    interface IVueConnexion{
        fun connexionReussi()
        fun connexionEchouer()
        fun naviguerVersDefiLecture()
    }
    interface IPrésentateurConnexion{
        fun validerIdentifiants( pseudonyme:String, mdp:String )
    }
}