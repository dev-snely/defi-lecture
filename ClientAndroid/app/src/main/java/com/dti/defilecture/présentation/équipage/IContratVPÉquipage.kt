package com.dti.defilecture.présentation.équipage

import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture

/**
 * Interface de contrats établissant les méthodes utiliser
 * dans un présentateur et sa vue correspondante.
 *
 */
interface IContratVPÉquipage {
    /**
     * Définit les méthodes à utiliser dans une vue Équipage.
     */
    interface IVueÉquipage{
        fun afficherTotalDoublons()

        fun afficherRang()

        fun naviguerVersDétailsCompteActif()

        fun naviguerVersDétailsCompteTemporaire()

        fun gestionAfficherComptesÉquipage( comptes: MutableList<Compte>? )
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur Équipage.
     */
    interface IPrésentateurÉquipage{

        fun initisaliseurDesComptes(nomÉquipage:String)


        fun requêteVoirDétailsCompte(pseudonyme: String, nomÉquipage: String)
    }
}